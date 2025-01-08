package com.springboot.crudoperation.ExceptionHandler;

public class ResourceNotfounException extends RuntimeException {

    private String resourceName;
    private  String fieldName;
    private  int fieldValue;

    // Constructor
    public ResourceNotfounException(String resourceName, String fieldName, int fieldValue) {
        super(String.format("%s not found for %s with value: '%d'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public  void setResourceName(String resourceName){
        this.resourceName=resourceName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldValue(int fieldValue) {
        this.fieldValue = fieldValue;
    }

    // Getters
    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getFieldValue() {
        return fieldValue;
    }

    @Override
    public String toString() {
        return "ResourceNotfounException{" +
                "resourceName='" + resourceName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue=" + fieldValue +
                '}';
    }
}
