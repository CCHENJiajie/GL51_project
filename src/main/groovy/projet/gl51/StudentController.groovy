package projet.gl51

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller("/student")
class StudentController {

    @Get("/")
    List<Student> index() {
        [new Student(firstName: "Jiajie1", lastName: "Sicong1")]
		[new Student(firstName: "Jiajie2", lastName: "Sicong2")]
		[new Student(firstName: "Jiajie3", lastName: "Sicong3")]
    }
}
