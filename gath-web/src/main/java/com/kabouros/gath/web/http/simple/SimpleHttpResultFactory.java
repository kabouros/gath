package com.kabouros.gath.web.http.simple;

import com.kabouros.gath.web.http.HttpResultFactory;
import com.kabouros.gath.web.http.HttpResultStatus;
import com.kabouros.gath.web.http.MutableHttpResult;

/**
 * Simple {@link ResponseFactoryMsg} implementation.
 *
 * This is the default fallback factory.
 *
 * @author JIANG
 */
public class SimpleHttpResultFactory implements HttpResultFactory {
	
    @Override
    public <T> MutableHttpResult<T> body(HttpResultStatus status, T body) {
        return new SimpleHttpResult<T>().status(status).body(body);
    }

    @Override
    public <T> MutableHttpResult<T> status(HttpResultStatus status, String reason) {
        return new SimpleHttpResult<T>().status(status).reason(reason);
    }

    @Override
    public <T> MutableHttpResult<T> build(HttpResultStatus status, String reason, T body) {
        return new SimpleHttpResult<T>().status(status).reason(reason).body(body);
    }

}
