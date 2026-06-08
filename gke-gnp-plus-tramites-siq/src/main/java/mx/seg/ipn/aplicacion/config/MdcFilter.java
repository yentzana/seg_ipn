package mx.seg.ipn.aplicacion.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(1)
public class MdcFilter extends OncePerRequestFilter {

	/**
	 * MDC log filter.
	 */
	@Override
	protected void doFilterInternal(
		final HttpServletRequest request,
		final HttpServletResponse response,
		final FilterChain filterChain
	) throws ServletException, IOException {
		try {
			final String token;
			token = UUID.randomUUID().toString().toUpperCase().replace("-", "");

			MDC.put("logTraceToken", token);
			response.addHeader("log-uuid", token);
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}
	}
}
