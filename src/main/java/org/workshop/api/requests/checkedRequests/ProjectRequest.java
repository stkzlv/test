package org.workshop.api.requests.checkedRequests;

import org.apache.http.HttpStatus;
import org.workshop.api.models.Project;
import org.workshop.api.models.User;
import org.workshop.api.requests.CrudInterface;
import org.workshop.api.requests.UncheckedRequests;

public class ProjectRequest implements CrudInterface {
    private User user;
    public ProjectRequest(User user) {
        this.user = user;
    }

    @Override
    public Project create(Object dto) {
        return new UncheckedRequests(user).projectRequest.create(dto)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response().as(Project.class);
    }

    @Override
    public Object get(String id) {
        return null;
    }

    @Override
    public Object update(Object dto) {
        return null;
    }

    @Override
    public String delete(String id) {
        return new UncheckedRequests(user).projectRequest.delete(id)
                .then().assertThat().statusCode(HttpStatus.SC_NO_CONTENT)
                .extract().response().asString();
    }
}
