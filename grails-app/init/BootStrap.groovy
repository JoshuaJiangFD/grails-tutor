import tutor.Author
import tutor.TutorialEntry

class BootStrap {

    def init = { servletContext ->
        def joshua = new Author(name: "Joshua")
        joshua.save()

        def root = new TutorialEntry(
                title: "1 Root Title",
                text: "Root holder for all entries",
                author: joshua
        )
        root.save()

        def previous=root
        for (i in 1..5) {
            def entry = new TutorialEntry(
                    title: "1.$i Some Title",
                    text: "a very long tex " * i,
                    author: joshua,
                    parentEntry: root,
                    predecessor: previous
            )
            entry.save()
        }
    }
    def destroy = {
    }
}
