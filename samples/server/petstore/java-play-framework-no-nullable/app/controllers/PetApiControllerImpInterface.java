package controllers;

import java.io.InputStream;
import apimodels.ModelApiResponse;
import apimodels.Pet;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.mvc.Controller;
import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import play.mvc.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import openapitools.OpenAPIUtils;
import openapitools.SecurityAPIUtils;
import static play.mvc.Results.ok;
import static play.mvc.Results.unauthorized;
import play.libs.Files.TemporaryFile;

import javax.validation.constraints.*;

@SuppressWarnings("RedundantThrows")
public abstract class PetApiControllerImpInterface {
    @Inject private Config configuration;
    @Inject private SecurityAPIUtils securityAPIUtils;
    private ObjectMapper mapper = new ObjectMapper();

    public Result addPetHttp(Http.Request request, Pet body) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        addPet(request, body);
        return ok();

    }

    public abstract void addPet(Http.Request request, Pet body) throws Exception;

    public Result deletePetHttp(Http.Request request, Long petId, String apiKey) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        deletePet(request, petId, apiKey);
        return ok();

    }

    public abstract void deletePet(Http.Request request, Long petId, String apiKey) throws Exception;

    public Result findPetsByStatusHttp(Http.Request request, @NotNull List<String> status) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        List<Pet> obj = findPetsByStatus(request, status);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Pet curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract List<Pet> findPetsByStatus(Http.Request request, @NotNull List<String> status) throws Exception;

    public Result findPetsByTagsHttp(Http.Request request, @NotNull List<String> tags) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        List<Pet> obj = findPetsByTags(request, tags);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (Pet curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract List<Pet> findPetsByTags(Http.Request request, @NotNull List<String> tags) throws Exception;

    public Result getPetByIdHttp(Http.Request request, Long petId) throws Exception {
        Pet obj = getPetById(request, petId);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract Pet getPetById(Http.Request request, Long petId) throws Exception;

    public Result updatePetHttp(Http.Request request, Pet body) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        updatePet(request, body);
        return ok();

    }

    public abstract void updatePet(Http.Request request, Pet body) throws Exception;

    public Result updatePetWithFormHttp(Http.Request request, Long petId, String name, String status) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        updatePetWithForm(request, petId, name, status);
        return ok();

    }

    public abstract void updatePetWithForm(Http.Request request, Long petId, String name, String status) throws Exception;

    public Result uploadFileHttp(Http.Request request, Long petId, String additionalMetadata, Http.MultipartFormData.FilePart<TemporaryFile> file) throws Exception {
        if (!securityAPIUtils.isRequestTokenValid(request, "petstore_auth")) {
            return unauthorized();
        }

        ModelApiResponse obj = uploadFile(request, petId, additionalMetadata, file);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract ModelApiResponse uploadFile(Http.Request request, Long petId, String additionalMetadata, Http.MultipartFormData.FilePart<TemporaryFile> file) throws Exception;

}
