/*
 * Copyright 2020.
 */
package com.stackabuse.tutorials.overriding;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
class Cricket {

    class Batsman {

        int scoreRun() {
            throw new UnsupportedOperationException();
        }
    }

class Coach {

    void motivateTeam() {
        throw new UnsupportedOperationException();

    }
}

class CricketCoach extends Coach {

    String analyzeGame() {
        throw new UnsupportedOperationException();
    }

    @Override
    void motivateTeam() {
        throw new UnsupportedOperationException();
    }

}
}
