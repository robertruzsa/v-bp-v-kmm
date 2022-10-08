//
//  OfferItem.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct OfferItem: View {
    
    var offer: Offer
    
    init(offer: Offer) {
        self.offer = offer
    }
    
    var body: some View {
        VStack {
            HStack {
                Text(offer.user.name)
                Spacer()
                Text(DateTimeUtil().humanizeDate(date: offer.dateOfTravel))
            }
            HStack {
                Text(String(offer.user.rating))
                Text("(" + String(offer.user.numberOfRatings) + ")")
                Spacer()
                Text(String(offer.numberOfSeats) + " szabad hely")
            }
            HStack {
                Spacer()
                Text(String(offer.priceInHuf) + " Ft")
            }
        }
    }
}

struct OfferItem_Previews: PreviewProvider {
    static var previews: some View {
        OfferItem(
            offer: Offer(
                user: User(
                    name: "John Doe",
                    rating: 4.7,
                    numberOfRatings: 12
                ),
                dateOfTravel: DateTimeUtil().now(),
                dateOfPost: DateTimeUtil().now(),
                route: Route(
                    startLocation: Location(name: "Torda"),
                    endLocation: Location(name: "Barót")
                ),
                numberOfSeats: 2,
                priceInHuf: 4000
            )
        )
    }
}
