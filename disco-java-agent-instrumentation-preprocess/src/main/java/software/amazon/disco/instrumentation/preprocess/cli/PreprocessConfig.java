/*
 * Copyright 2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package software.amazon.disco.instrumentation.preprocess.cli;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import org.apache.logging.log4j.Level;

import java.util.Map;
import java.util.Set;

/**
 * Container for the config created from the command line args
 */
@Builder
@Getter
public class PreprocessConfig {
    /**
     * a set of sources to be processed indexed by their corresponding relative path on the deployed environment. For instance, one
     * possible map entry is the paths to 'aws-java-sdk-core' as value and 'lib' as key.
     */
    @Singular
    private final Map<String, Set<String>> sourcePaths;

    private final String outputDir;
    private final String agentPath;
    private final String suffix;
    private final Level logLevel;
    private final String serializationJarPath;
    private final String javaVersion;
    private final String agentArg;
    private final String jdkPath;
    private final boolean failOnUnresolvableDependency;

    public Level getLogLevel() {
        if(logLevel == null){
            return Level.INFO;
        }
        return logLevel;
    }
}
