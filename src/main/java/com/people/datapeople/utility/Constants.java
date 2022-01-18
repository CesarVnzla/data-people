package com.people.datapeople.utility;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Constants {

    public static final Integer E_GENERAL_EXCEPTION_CODE=500;
    public static final String E_GENERAL_EXCEPTION="Error: %s";

    public static final Integer EXCEPTION_VALIDATION_CODE=400;
    public static final String EXCEPTION_VALIDATION_MESSAGE="El campo: %s";
    public static final String SEPARATOR="; nested exception is";

    public static final Integer CODE_BUSINIESS_EXCEPTION=200;
    public static final Integer CODE_CONNECTION_EXCEPTION=500;
    public static final String MESSAGE_GETLIST_EXCEPTION="Error al consultar la lista de personas";
    public static final String MESSAGE_FINDBYID_EXCEPTION="No se encontro la persona con el ID: ";
    public static final String MESSAGE_SAVE_EXCEPTION="Error al registrar la persona del ID: ";
    public static final String MESSAGE_UPDATE_EXCEPTION="Error al actualizar los datos del ID: ";
    public static final String MESSAGE_DELETE_EXCEPTION="Error al eliminar los datos del ID: ";

    public static final String VALIDATE_LONGITUD=" debe tener una longitud entre 4 y 20 caracteres";
    public static final String VALIDATE_LONGITUD_DOCUMENT=" debe tener una longitud entre 9 y 11 caracteres";

    public static final String MESSAGE=" no debe estar vacio";

    public static final String REQUEST_MAPPING_PATH="/api";

    public static final String PATH_GET_PEOPLE="/people";
    public static final String PATH_GET_UPDATE_DELETE_PEOPLE_BY_ID="/people/{id}";
    public static final String PATH_CREATE_PEOPLE="/people";

    public static final String OPERATION_GET_PEOPLE="Consulta la lista de personas registradas";
    public static final String OPERATION_GET_PEOPLE_BY_ID="Consulta una persona por su id";
    public static final String OPERATION_CREATE_PEOPLE="Registra una persona";
    public static final String OPERATION_UPDATE_PEOPLE="Actualiza los datos de una persona registrada";
    public static final String OPERATION_DELETE_PEOPLE="Elimina una persona Registrada";

    public static final String CODE_RESPONSE_OK="200";
    public static final String CODE_RESPONSE_OK_NO_CONTENT="204";
    public static final String CODE_RESPONSE_BAD_REQUEST="400";
    public static final String CODE_RESPONSE_NOT_FOUND="404";
    public static final String MESSAGE_RESPONSE_OK="Success";
    public static final String MESSAGE_RESPONSE_OK_NO_CONTENT="No Content";
    public static final String MESSAGE_RESPONSE_BAD_REQUEST="Invalid id supplied probando";
    public static final String MESSAGE_RESPONSE_NOT_FOUND="Book not found";

    public static final String MEDIA_TYPE="application/json";

    public static final String INFO_API_TITLE="API-PEOPLE";
    public static final String INFO_API_VERSION="1.0";
    public static final String INFO_API_DESCRIPTION="Api que consulta los datos de personas";

}
