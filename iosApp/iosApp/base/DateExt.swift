//
//  DateExt.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 13..
//  Copyright © 2022. orgName. All rights reserved.
//

import Foundation
import shared

extension Date {
    func toKotlinDate() -> Kotlinx_datetimeLocalDateTime {
        let calendar = Calendar.current

        let year = Int32(calendar.component(.year, from: self))
        let month = Int32(calendar.component(.month, from: self))
        let day = Int32(calendar.component(.day, from: self))
        let hour = Int32(calendar.component(.hour, from: self))
        let minute = Int32(calendar.component(.minute, from: self))
        let second = Int32(calendar.component(.second, from: self))
        let nanosecond = Int32(calendar.component(.nanosecond, from: self))
        
        return Kotlinx_datetimeLocalDateTime(
            year: year,
            monthNumber: month,
            dayOfMonth: day,
            hour: hour,
            minute: minute,
            second: second,
            nanosecond: nanosecond
        )
    }
    
    func humanized() -> String {
        let languageCode = NSLocale.current.languageCode ?? "en"
        return DateTimeUtil.shared.humanizeDate(date: self.toKotlinDate(), languageCode: languageCode)
    }
}
