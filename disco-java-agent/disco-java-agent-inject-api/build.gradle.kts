/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License").
 *   You may not use this file except in compliance with the License.
 *   A copy of the License is located at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file. This file is distributed
 *   on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *   express or implied. See the License for the specific language governing
 *   permissions and limitations under the License.
 */

plugins {
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow")
}

dependencies {
    //we use the ByteBuddyAgent for an install-after-startup injection strategy, but do not want to inadvertently
    //pull all of BB into the client's code.
    implementation("net.bytebuddy", "byte-buddy-agent", "1.10.14")
    compileOnly(project(":disco-java-agent:disco-java-agent-api"))

    testImplementation("net.bytebuddy", "byte-buddy-dep", "1.10.14")
    testImplementation(project(":disco-java-agent:disco-java-agent-api"))
}

tasks.named("shadowJar") {
    mustRunAfter(":disco-java-agent:disco-java-agent-core:test")
}
