package tutor

class TutorialEntry {

    String title
    TutorialEntry parentEntry
    String text
    Author author
    TutorialEntry predecessor

    String toString() { title }


    static constraints = {
    }
}
