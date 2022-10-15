//
//  DatePickerScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 11..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct DatePickerScreen: View {
    
    @Binding var selectedDate: Date
    
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        NavigationView {
            VStack {
                DatePicker(
                    "",
                    selection: $selectedDate,
                    displayedComponents: [.date]
                )
                .onChange(of: selectedDate, perform: { date in
                    selectedDate = date
                    dismiss()
                })
                .padding()
                .datePickerStyle(.graphical)
                .navigationTitle("Mikor utazol?")
                .toolbar {
                    Button(
                        action: { dismiss()}
                    ) {
                        Image(systemName: "xmark")
                    }
                }
                Spacer()
            }
        }
    }
    
    private func dismiss() {
        presentationMode.wrappedValue.dismiss()
    }
}

struct DatePickerScreen_Previews: PreviewProvider {
    static var previews: some View {
        DatePickerScreen(selectedDate: .constant(Date()))
    }
}
