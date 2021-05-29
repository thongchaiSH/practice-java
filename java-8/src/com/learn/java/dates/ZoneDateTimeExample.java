package com.learn.java.dates;

import java.time.*;

public class ZoneDateTimeExample {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime:" + zonedDateTime);

        System.out.println("getOffset:" + zonedDateTime.getOffset());

        System.out.println("Zone Id" + zonedDateTime.getZone());

//        System.out.println("AvailableZone:" + ZoneId.getAvailableZoneIds());

        ZoneId.getAvailableZoneIds().stream()
                .forEach(System.out::println);

        //Current Time
        System.out.println("Chicago CST:" + ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("Detroit CST:" + ZonedDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("Bangkok CST:" + ZonedDateTime.now(ZoneId.of("Asia/Bangkok")));

        System.out.println("ZoneDateTime using clock :" + ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Bangkok"))));

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Bangkok"));
        System.out.println("Bangkok:" + localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Bangkok")));
        System.out.println("Bangkok:" + localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("ofInstant:" + localDateTime2);

        /**
         * Convert from localDateTime , instant to ZoneDateTime
         */
        LocalDateTime localDateTime3 = LocalDateTime.now();
        System.out.println("localDateTime3:" + localDateTime3);

        ZonedDateTime zonedDateTime1 = localDateTime3.atZone(ZoneId.of("Asia/Bangkok"));
        System.out.println("zonedDateTime1:" + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Detroit"));
        System.out.println("zonedDateTime2:" + zonedDateTime2);

        OffsetDateTime offsetDateTime= localDateTime3.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("offsetDateTime:"+offsetDateTime);

    }
}
