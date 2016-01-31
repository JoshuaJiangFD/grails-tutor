package tutor

class WikiTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def replacements = [
            [ "\n" , "<br>\n"],
            [ "<br>\n\\s*<br>\n" , "<p/>\n"],
            [ /\*(\b[^\*]*?\b)\*/ , '<b>$1</b>' ],
            [ /~(\b[^~]*?\b)~/ , '<i>$1</i>' ],
            [ /\b_([^_]*?)_\b/ ,
              '<div style="text-decoration:underline">$1</div>' ],
    ]
    def wikify = { attributes ->
        def text = attributes.text
        for (pair in replacements) {
            text = text.replaceAll(pair[0], pair[1])
        }
        out << text
    }
}
