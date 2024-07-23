package com.ironhack.Lab8;

import com.ironhack.Lab8.model.Member;
import com.ironhack.associationofnurses.model.*;
import com.ironhack.associationofnurses.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;


@SpringBootTest
class AssociationOfNursesApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {

    }

    @Bean
    CommandLineRunner commandLineRunner(ChapterRepository chapterRepository,
                                        MemberRepository memberRepository, ConferenceRepository conferenceRepository,
                                        SpeakerRepository speakerRepository, GuestRepository guestRepository) {
        return args -> {

            // Creating Members
            Member member1 = new Member();
            member1.setName("Alice Smith");
            member1.setStatus(MemberStatus.ACTIVE);
            member1.setRenewalDate(LocalDate.of(2024, 6, 30));

            Member member2 = new Member();
            member2.setName("Dr. Omolola Amayo");
            member2.setStatus(MemberStatus.LAPSED);
            member2.setRenewalDate(LocalDate.of(2023, 11, 31));

            Member president = new Member();
            president.setName("Dr. Ogie Henry");
            president.setStatus(MemberStatus.ACTIVE);
            president.setRenewalDate(LocalDate.of(2022, 11, 26));

            memberRepository.saveAll(Arrays.asList(member1, member2, president));

            // Creating Chapter
            Chapter chapter = new Chapter();
            chapter.setName("Essen-North District");
            chapter.setDistrict("Essen-North");
            chapter.setPresident(president);
            chapter.setMembers(Arrays.asList(member1, member2));

            chapterRepository.saveAll(Arrays.asList(chapter));

            // Creating Guest
            Guest guest1 = new Guest();
            guest1.setName("Dr. Wendy Aibueku");
            guest1.setStatus(ResponseStatus.ATTENDING);


            Guest guest2 = new Guest();
            guest2.setName("Dr. Amayo Kendra");
            guest2.setStatus(ResponseStatus.ATTENDING);

            guestRepository.saveAll(Arrays.asList(guest1, guest2));

            // Creating Speakers
            Speaker speaker1 = new Speaker();
            speaker1.setName("Dr. Faith Aibueku");
            speaker1.setPresentationDuration(60);
            Duration duration = Duration.ofHours(1);


            Speaker speaker2 = new Speaker();
            speaker2.setName("Dr. Clemzo Amayo");
            speaker2.setPresentationDuration(45);
            Duration duration2 = Duration.ofMinutes(45);

            speakerRepository.saveAll(Arrays.asList(speaker1, speaker2));


            // Creating a Conference
            Conference conference = new Conference();
            conference.setDate(LocalDate.of(2024, 7, 20));
            conference.setDuration(2);
            Duration duration3 = Duration.ofDays(2);
            conference.setLocation("Convention Center");
            conference.setTitle("Annual Health Conference");
            conference.setGuests(Arrays.asList(guest1, guest2));
            conference.setSpeakers(Arrays.asList(speaker1, speaker2));


            // Creating an Exposition
            Exposition exposition = new Exposition();
            exposition.setDate(LocalDate.of(2024, 8, 10));
            exposition.setDuration(60);
            Duration duration4 = Duration.ofHours(8);
            exposition.setLocation("Expo Hall");
            exposition.setTitle("Medical Equipment Expo");
            exposition.setGuests(Arrays.asList(guest1));

            conferenceRepository.save(conference);

            // Assign members to chapter
            member1.setChapter(chapter);
            member2.setChapter(chapter);
            president.setChapter(chapter);

            memberRepository.saveAll(Arrays.asList(member1, member2, president));

            // Assign events to guests
            guest1.setEvent(conference);
            guest2.setEvent(conference);
            guestRepository.saveAll(Arrays.asList(guest1, guest2));
        };

    }
}
