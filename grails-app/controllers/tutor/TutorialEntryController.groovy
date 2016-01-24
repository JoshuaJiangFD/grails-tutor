package tutor

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TutorialEntryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond TutorialEntry.list(params), model:[tutorialEntryCount: TutorialEntry.count()]
    }

    def show(TutorialEntry tutorialEntry) {
        respond tutorialEntry
    }

    def create() {
        respond new TutorialEntry(params)
    }

    @Transactional
    def save(TutorialEntry tutorialEntry) {
        if (tutorialEntry == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tutorialEntry.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tutorialEntry.errors, view:'create'
            return
        }

        tutorialEntry.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tutorialEntry.label', default: 'TutorialEntry'), tutorialEntry.id])
                redirect tutorialEntry
            }
            '*' { respond tutorialEntry, [status: CREATED] }
        }
    }

    def edit(TutorialEntry tutorialEntry) {
        respond tutorialEntry
    }

    @Transactional
    def update(TutorialEntry tutorialEntry) {
        if (tutorialEntry == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tutorialEntry.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tutorialEntry.errors, view:'edit'
            return
        }

        tutorialEntry.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tutorialEntry.label', default: 'TutorialEntry'), tutorialEntry.id])
                redirect tutorialEntry
            }
            '*'{ respond tutorialEntry, [status: OK] }
        }
    }

    @Transactional
    def delete(TutorialEntry tutorialEntry) {

        if (tutorialEntry == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tutorialEntry.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tutorialEntry.label', default: 'TutorialEntry'), tutorialEntry.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tutorialEntry.label', default: 'TutorialEntry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
