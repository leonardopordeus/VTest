package br.com.leonardopordeus.VTest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import br.com.leonardopordeus.VTest.customer.dto.ExceptionDto;

@ControllerAdvice
public class ExceptionHandler {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionDto> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ExceptionDto exceptionDto = null;
		if (e instanceof BusinessException) {
			LOGGER.error(e.getMessage(), e);
			exceptionDto = new ExceptionDto("BusinessException",e.getMessage());
		} else if (e instanceof IllegalArgumentException) {
			LOGGER.error(e.getMessage(), e);
			exceptionDto = new ExceptionDto("IllegalArgumentException",e.getMessage());
		} else if (e instanceof DataIntegrityViolationException) {
			LOGGER.error(e.getMessage(), e);
			exceptionDto = new ExceptionDto("DataIntegrityViolationException",e.getMessage());
		} else {
			LOGGER.error(e.getMessage(), e);
			exceptionDto = new ExceptionDto("UNKNOWN",e.getMessage());
		}
		return new ResponseEntity<ExceptionDto>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
