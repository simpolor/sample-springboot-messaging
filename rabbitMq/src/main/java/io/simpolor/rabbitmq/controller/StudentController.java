package io.simpolor.rabbitmq.controller;

import io.simpolor.rabbitmq.message.MessageProducer;
import io.simpolor.rabbitmq.model.ResultDto;
import io.simpolor.rabbitmq.model.StudentDto;
import io.simpolor.rabbitmq.repository.entity.Student;
import io.simpolor.rabbitmq.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	private final MessageProducer messageProducer;

	@RequestMapping(value="", method= RequestMethod.GET)
	public List<StudentDto> list() {

		List<Student> students = studentService.getAll();
		if(CollectionUtils.isEmpty(students)){
			return Collections.EMPTY_LIST;
		}

		return StudentDto.of(students);
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.GET)
	public StudentDto detail(@PathVariable Long studentId) {

		Student student = studentService.get(studentId);

		return StudentDto.of(student);
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public ResultDto register(@RequestBody StudentDto request) {

		Student student = studentService.create(request.toEntity());

		StudentDto dto = StudentDto.of(student);

		messageProducer.sendMessage(dto.toString());

		return ResultDto.builder()
				.id(student.getStudentId())
				.build();
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.PUT)
	public void modify(@PathVariable Long studentId,
					   @RequestBody StudentDto request) {

		request.setId(studentId);
		studentService.update(request.toEntity());
	}

	@RequestMapping(value="/{studentId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long studentId) {

		studentService.delete(studentId);
	}
}
