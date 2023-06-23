package com.example.coachingsystem.Coaching;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CoachingService {
    public static  List<Coaching>coachings=new ArrayList<>();
    public static int id=0;
    static {
        coachings.add(new Coaching(++id,"rahul","learn java Core", LocalDate.now().plusYears(1),false));
        coachings.add(new Coaching(++id,"ramesh","learn Spring", LocalDate.now().plusYears(2),false));
        coachings.add(new Coaching(++id,"sita","learn java Core", LocalDate.now().plusYears(1),false));
    }
        public List<Coaching> findByUsername(String username) {
            Predicate<? super Coaching> predicate = coaching -> coaching.getUsername().equalsIgnoreCase(username);
            return coachings.stream().filter(predicate).toList();
        }

    public void addStudent(String name, String courseName, LocalDate target,boolean done ){
        coachings.add(new Coaching(++id,name,courseName,target,done));
    }
    public void deleteById(int id){
        Predicate<? super Coaching> predicate=coaching -> coaching.getId()==id;
        coachings.removeIf(predicate);
    }

    public Coaching findById(int id) {
        Predicate<? super Coaching> predicate=coaching -> coaching.getId()==id;
       Coaching c= coachings.stream().filter(predicate).findFirst().get();
        return c;
    }


    public void updateStudent(@Valid Coaching ce) {
        deleteById(ce.getId());
        coachings.add(ce);

    }
}
