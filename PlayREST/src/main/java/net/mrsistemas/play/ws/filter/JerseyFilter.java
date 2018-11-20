package net.mrsistemas.play.ws.filter;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class JerseyFilter {

    @Context
    private HttpServletResponse servletResponse;

	// @Override
	// public void filter(ContainerRequestContext requestContext) throws
	// IOException {
	// System.out.println("Intentando procesar la solicitud.");
	//
	// URI myURI = requestContext.getUriInfo().getAbsolutePath();
	// String myPath = myURI.getPath();
	//
	// if(myPath.equals("/rest/getApiKey")) {
	// Iterator it = requestContext.getCookies().entrySet().iterator();
	// String accountHref = "";
	// while(it.hasNext()) {
	// Map.Entry pairs = (Map.Entry)it.next();
	// if(pairs.getKey().equals("accountHref")) {
	// String hrefCookie = pairs.getValue().toString();
	// accountHref = hrefCookie.substring(hrefCookie.indexOf("https://"));
	// }
	// }
	// if(!accountHref.equals("")) {
	// //Cookie exists, continue.
	// return;
	// }
	// else {
	// System.out.println("Not logged in");
	// servletResponse.sendError(403);
	// }
	//
	// }
	//
	// }
	//
	// @Override
	// public void filter(ContainerRequestContext requestContext,
	// ContainerResponseContext responseContext) throws IOException {
	// System.out.println("Procesando...........");
	//
	// final MultivaluedMap<String,Object> headers =
	// responseContext.getHeaders();
	//
	// headers.add("Access-Control-Allow-Methods",
	// "GET,POST,PUT,DELETE,OPTIONS");
	// headers.add("Access-Control-Allow-Origin", "*");
	//
	// if(requestContext.getMethod().equalsIgnoreCase("OPTIONS")){
	// headers.add("Access-Control-Allow-Headers",
	// requestContext.getHeaderString("Access-Control-Request-Headers"));
	// }
	// System.out.println("Procesando 2...........");
	// }
	//
	// @Override
	// public OutputStream writeResponseStatusAndHeaders(long contentLength,
	// ContainerResponse responseContext)
	// throws ContainerException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public boolean suspend(long timeOut, TimeUnit timeUnit, TimeoutHandler
	// timeoutHandler) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public void setSuspendTimeout(long timeOut, TimeUnit timeUnit) throws
	// IllegalStateException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void commit() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void failure(Throwable error) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public boolean enableResponseBuffering() {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public OutputStream writeResponseStatusAndHeaders(long contentLength,
	// ContainerResponse responseContext)
	// throws ContainerException {
	// // TODO Auto-generated method stub
	// return null;
	// }
}