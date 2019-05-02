
package project.gl51

import io.micronaut.context.ApplicationContext
import io.micronaut.core.type.Argument
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class StudentControllerSpec extends Specification {

  


    void "test index"() {
        given:
        def response = client.toBlocking().exchange("/student", Argument.listOf(Student).type)

        expect:
        response.status == HttpStatus.OK
        response.body()[0].firstName == 'Sébastien'
        response.body()[0].lastName == 'Gadot'

    }
}
