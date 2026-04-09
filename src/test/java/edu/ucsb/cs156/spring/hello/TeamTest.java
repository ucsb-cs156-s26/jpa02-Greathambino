package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // case 1: equals should return true for the same object
    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    // case 2: equals should return false for different classes
    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("This is a string, not a team"));
    }

    // case 3 T:T 
    @Test
    public void equals_returns_true_for_same_name_and_members() {
        Team t1 = new Team("team1");
        t1.addMember("Jeff");

        Team t2 = new Team("team1");
        t2.addMember("Jeff");

        assertTrue(t1.equals(t2));
    }

    // case 3 T:F
    @Test
    public void equals_returns_true_for_same_name_and_diff_members() {
        Team t1 = new Team("team1");
        t1.addMember("Jeff");

        Team t2 = new Team("team1");
        t2.addMember("Lebron");

        assertFalse(t1.equals(t2));
    }

    // case 3 F:T 
    @Test
    public void equals_returns_true_for_diff_name_and_same_members() {
        Team t1 = new Team("BLAHBLAHBLAH");
        t1.addMember("Jeff");

        Team t2 = new Team("team1");
        t2.addMember("Jeff");

        assertFalse(t1.equals(t2));
    }

    // case 3 F:F not sure that I really need this test case, but I put it anyway out of principle
    @Test
    public void equals_returns_true_for_diff_name_and_diff_members() {
        Team t1 = new Team("lol");
        t1.addMember("hi");

        Team t2 = new Team("lmao");
        t2.addMember("hello");

        assertFalse(t1.equals(t2));
    }

    // hashcode temporary test
    @Test
    public void hashCode_test() {
        Team t = new Team("test");
        int result = t.hashCode();
        int expectedResult = 3556499;
        assertEquals(expectedResult, result);
    }

}
