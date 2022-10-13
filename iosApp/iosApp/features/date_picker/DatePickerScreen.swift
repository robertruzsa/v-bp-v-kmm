//
//  DatePickerScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 11..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct DatePickerScreen: View {
    @State private var date = Date()
    
    var body: some View {
        NavigationView {
            VStack {
                DatePicker(
                    "",
                    selection: $date,
                    displayedComponents: [.date]
                )
                .padding()
                .datePickerStyle(.graphical)
                .navigationTitle("Mikor utazol?")
                Spacer()
            }
        }
    }
}

struct DatePickerScreen_Previews: PreviewProvider {
    static var previews: some View {
        DatePickerScreen()
    }
}
