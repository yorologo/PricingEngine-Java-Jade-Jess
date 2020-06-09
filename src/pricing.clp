;; First define templates for the model classes so we can use them
;; in our pricing rules. This doesn't create any model objects --
;; it just tells Jess to examine the classes and set up templates
;; using their properties

(import gov.sandia.jess.example.pricing.model.*)
(deftemplate Order       (declare (from-class Order)))
(deftemplate OrderItem   (declare (from-class OrderItem)))
(deftemplate CatalogItem (declare (from-class CatalogItem)))
(deftemplate Customer    (declare (from-class Customer)))

;; Now define the pricing rules themselves. Each rule matches a set
;; of conditions and then creates an Offer object to represent a
;; bonus of some kind given to a customer. The rules assume that
;; there will be just one Order, its OrderItems, and its Customer in 
;; working memory, along with all the CatalogItems.

(defrule 10%-volume-discount
    "Give a 10% discount to everybody who spends more than $100."
    ?o <- (Order {total > 100})
    =>
    (add (new Offer "10% volume discount" (/ ?o.total 10))))

(defrule 25%-multi-item-discount
    "Give a 25% discount on items the customer buys three or more of."
    (OrderItem {quantity >= 3} (price ?price))
    =>
    (add (new Offer "25% multi-item discount" (/ ?price 4))))

(defrule free-cd-rw-disks
    "If somebody buys a CD writer, send them a free sample of CD-RW
    disks, catalog number 782321; but only if they're a repeat customer.
    We use a regular expression to match the CD writer's description."
    (CatalogItem (partNumber ?partNumber) (description /CD Writer/))
    (CatalogItem (partNumber 782321) (price ?price))
    (OrderItem (partNumber ?partNumber))
    (Customer {orderCount > 1})
    =>	
    (add (new Offer "Free CD-RW disks" ?price)))

(defrule 24-months-without-interest
    "When buying an iPhone 11 Pro with Banamex cards, offer 24 months without interest."
    (CatalogItem (partNumber ?partNumber) (description /iPhone 11 Pro by Apple/))
    (OrderItem (partNumber ?partNumber))
    (OrderItem (creditCard /Banamex/))
    =>
    (add (new Offer "24 months without interest")))

(defrule 12-months-without-interest
    "In the purchase of a Samsung Note 11, with Liverpool VISA card, offer 12 months without interest."
    (CatalogItem (partNumber ?partNumber) (description /Note 11 by Samsung/))
    (OrderItem (partNumber ?partNumber))
    (OrderItem (creditCard /Liverpool VISA/))
    =>
    (add (new Offer "12 months without interest")))

(defrule 100-in-vouchers-for-every-1000
    "In the purchase of a MacBook Air, offer $100 in vouchers for every $1000 in the purchase."
    (CatalogItem (partNumber ?partNumber) (description /MacBook Air by Apple/))
    (OrderItem (partNumber ?partNumber))
    ?o <- (Order {total > 1000})
    =>
    (add (new Offer "Vouchers " 0 (/ ?o.total 1000))))
