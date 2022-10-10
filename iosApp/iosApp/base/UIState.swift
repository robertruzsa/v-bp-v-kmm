//
//  UIState.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import Foundation

enum UIState<T> {
    case loading
    case result(T)
    case error(String)
}
