package com.example.xiaoxinma.happytrails;

import java.util.ArrayList;
import java.lang.Math;

/**
 * Created by XiaoxinMa on 4/23/17.
 */

public class TrailList {

    private Trail head;
    private Trail tail;

    public Trail getHead(){
        return head;
    }

    public Trail getTail(){
        return tail;
    }


    public TrailList() {
        this.head = null;
        this.tail = null;
    }

    public void add(Trail trail) {
        if (head == null){
            head = trail;
            tail = trail;
        }
        else {
            Trail curr = head;
            Trail prev = curr;
            while(curr != null) {
                if (trail.getName().compareTo(curr.getName()) >= 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    if (curr != prev) {
                        trail.next = prev.next;
                        prev.next = trail;
                        return;
                    } else {
                        trail.next = head;
                        head = trail;
                        return;
                    }
                }
            }
            prev.next = trail;
            tail = trail;
        }
    }

    public void remove(String name) {
        Trail curr = head;
        Trail prev = curr;
        while(curr != null) {
            if (name.equals(curr.getName())) {
                if (curr == head){
                    head = curr.next;
                }
                else{
                    prev.next = curr.next;
                    if (prev.next == null){
                        tail = prev;
                    }
                }
                if (head == null)
                    tail = null;
                return;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

    }



    public String displayAlphabet() {
        Trail curr = head;
        String result = "";
        while (curr != null) {
            result += curr.toString();
            result += "\n";
            curr = curr.next;
        }

        return result;
    }

    public String displayRate(int rating) {
        Trail curr = head;
        String result = "";
        while(curr != null) {
            if (curr.getRating() >= rating) {
                result += curr.toString();
                result += "\n";
                curr = curr.next;
            }else {
                curr = curr.next;
            }
        }
        return result;
    }

    //5)display trails in a state
    public String displayState(String state) {
        Trail curr = head;
        String result = "";
        while(curr != null) {
            if (curr.getState().equals(state) && curr.isHaveHiked() == false ) {
                result += curr.toString();
                result += "\n";
                curr = curr.next;
            }else {
                curr = curr.next;
            }
        }
        return result;
    }

    //6)display trails most proximal to a specified trail
    public String displayProximal(String name) {
        Trail curr = head;
        Trail prev = curr;
        Trail aft = curr.next;
        String result = "";

        double distance = 3959.0 * Math.acos(Math.sin(curr.getLatitude()) * Math.sin(curr.next.getLatitude())
                            + Math.cos(curr.getLatitude()) * Math.cos(curr.next.getLatitude()));

        double distanceNext = 3959.0 * Math.acos(Math.sin(curr.next.getLatitude()) * Math.sin(curr.next.next.getLatitude())
                + Math.cos(curr.next.getLatitude()) * Math.cos(curr.next.next.getLatitude()));

        double distancePrev = 3959.0 * Math.acos(Math.sin(prev.getLatitude()) * Math.sin(curr.getLatitude())
                + Math.cos(prev.getLatitude()) * Math.cos(curr.getLatitude()));

        double distancePrevNext = 3959.0 * Math.acos(Math.sin(prev.getLatitude()) * Math.sin(curr.getLatitude())
                + Math.cos(prev.getLatitude()) * Math.cos(curr.getLatitude()));

        while(curr != null) {
            if (name.equals(curr.getName())) {
                if (aft != null && aft.next != null) {
                    if (distance < distanceNext) {
                        result += curr.toString();
                        result += "\n";
                    }else{
                        curr = curr.next;
                    }
                } else if (prev != null && prev.next != null){
                    if (distancePrev < distancePrevNext) {
                        result += prev.toString();
                        result += "\n";
                    }else{
                        curr = curr.next;
                    }
                }
            }else {
                curr = curr.next;
            }
        }
        return result;


    }


    //7)list trails containing a specified landmark
    public String displayLandmark(String landmark) {
        Trail curr = head;
        String result = "";
        while(curr != null) {
            if (curr.getLandmarks().equals(landmark)) {
                result += curr.toString();
                result += "\n";
                curr = curr.next;
            }else {
                curr = curr.next;
            }
        }
        return result;
    }
    //8)list trails the user hasn't hiked
    public String displayIsNotHiked() {
        Trail curr = head;
        String result = "";
        while(curr != null) {
            if (!curr.isHaveHiked()) {
                result += curr.toString();
                result += "\n" + "We recommend hiking:" + curr.getState() +", " + "\n" +
                        "where" + curr.getName() + "is the name of " + "\n" +
                        "the unhiked trail with the highest rating.";
                curr = curr.next;
            }else {
                curr = curr.next;
            }
        }
        return result;
    }


}
