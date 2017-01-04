package com.jaredsburrows.license.internal.report.json

import com.jaredsburrows.license.internal.License
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
@Builder(excludes = "jsonObject")
@EqualsAndHashCode(includeFields = true, useCanEqual = false)
@ToString(includeNames = true, includePackage = false)
final class JsonReportObject {
  final static def PROJECT = "project"
  final static def DEVELOPERS = "developers"
  final static def URL = "url"
  final static def YEAR = "year"
  final static def LICENSE = "license"
  final static def LICENSE_URL = "license_url"
  final def jsonObject = [:]
  String name
  String developers
  String url
  String year
  License license

  /**
   * Convert object to a JsonObject.
   */
  def jsonObject() {
    // Project name
    jsonObject.put(PROJECT, name)

    // Authors/developers
    if (developers) jsonObject.put(DEVELOPERS, developers)

    // Project url
    if (url) jsonObject.put(URL, url)

    // Inception year
    if (year) jsonObject.put(YEAR, year)

    // Project license
    if (license?.name) jsonObject.put(LICENSE, license.name)
    if (license?.url) jsonObject.put(LICENSE_URL, license.url)

    jsonObject
  }
}
