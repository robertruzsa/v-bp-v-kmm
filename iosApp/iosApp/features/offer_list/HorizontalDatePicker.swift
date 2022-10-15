//
//  HorizontalDatePicker.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 15..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct HorizontalDatePicker: View {
    
    var selectableDates: [Kotlinx_datetimeLocalDateTime]
    
    @State var selectedDate: Kotlinx_datetimeLocalDateTime
    
    var body: some View {
        ScrollView(.horizontal, showsIndicators: false) {
                HStack {
                    ForEach(selectableDates) { date in
                        VStack(spacing: 0) {
                            Text(DateTimeUtil.shared.formatHorizontalPickerDate(dateTime: date))
                                .multilineTextAlignment(.center)
                                .font(.subheadline)
                                .padding(.horizontal, 5.0)
                                .onTapGesture {
                                    self.selectedDate = date
                                }
                            if (self.selectedDate == date) {
                                Divider()
                                    .frame(height: 2.0)
                                    .overlay(Color(.systemBlue))
                            } else {
                                Divider()
                                    .frame(height: 2.0)
                                    .opacity(0)
                            }
                        }
                    }
                }
        }
    }
}

struct HorizontalDatePicker_Previews: PreviewProvider {
    static var previews: some View {
        HorizontalDatePicker(selectableDates: [], selectedDate: DateTimeUtil.shared.now())
    }
}
