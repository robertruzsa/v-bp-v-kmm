//
//  SelectValueButton.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct SelectValueButton: View {
    
    let label: String
    var value: String? = nil
    let startIconSystemName: String
    let onClick: () -> Void
    
    init(label: String, value: String?, startIconSystemName: String, onClick: @escaping () -> Void) {
        self.label = label
        self.value = value
        self.startIconSystemName = startIconSystemName
        self.onClick = onClick
    }
    
    var body: some View {
        Button(
            action: {
                onClick()
            }
        ) {
            HStack {
                Image(systemName: startIconSystemName)
                VStack(alignment: HorizontalAlignment.leading) {
                    Text(label)
                    if (self.value != nil && self.value != "") {
                        Text(value!)
                    }
                }
                Spacer()
                Image(systemName: "chevron.right")
            }
        }
    }
}

struct SelectValueButton_Previews: PreviewProvider {
    static var previews: some View {
        SelectValueButton(
            label: "Select value", value: nil, startIconSystemName: "plus", onClick: {}
        )
    }
}
