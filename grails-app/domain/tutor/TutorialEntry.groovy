package tutor

class TutorialEntry {

    String title
    TutorialEntry parentEntry
    String text
    Author author

    String toString() { title }


    static constraints = {
    }
}
