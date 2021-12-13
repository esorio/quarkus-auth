package org.acme.getting.started;

import io.quarkus.security.AuthenticationFailedException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFailMapper implements ExceptionMapper<AuthenticationFailedException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(AuthenticationFailedException exception) {
        System.out.println("AuthFailMapper.toResponse " + exception.getMessage());
        return Response.status(401).header("WWW-Authenticate", "Basic realm=\"Quarkus\"").build();
    }
}
