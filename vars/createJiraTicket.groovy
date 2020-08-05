#!/usr/bin/env groovy

def call(Map config, callback) {
    callback()
    echo config.summary

}