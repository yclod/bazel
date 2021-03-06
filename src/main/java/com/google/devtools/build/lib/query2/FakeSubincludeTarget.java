// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.query2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.packages.ConstantRuleVisibility;
import com.google.devtools.build.lib.packages.License;
import com.google.devtools.build.lib.packages.Package;
import com.google.devtools.build.lib.packages.Rule;
import com.google.devtools.build.lib.packages.RuleVisibility;
import com.google.devtools.build.lib.packages.Target;
import com.google.devtools.build.lib.syntax.Label;

import java.util.Set;

/**
 * A fake Target - Use only so that "blaze query" can report subincluded files as Targets.
 */
public class FakeSubincludeTarget implements Target {

  private final Label label;
  private final Location location;

  FakeSubincludeTarget(Label label, Location location) {
    this.label = Preconditions.checkNotNull(label);
    this.location = Preconditions.checkNotNull(location);
  }

  @Override
  public Label getLabel() {
    return label;
  }

  @Override
  public String getName() {
    return label.getName();
  }

  @Override
  public Package getPackage() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getTargetKind() {
    return "source file";
  }

  @Override
  public Rule getAssociatedRule() {
    return null;
  }

  @Override
  public License getLicense() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public Set<License.DistributionType> getDistributions() {
    return ImmutableSet.of();
  }

  @Override
  public RuleVisibility getVisibility() {
    return ConstantRuleVisibility.PUBLIC;
  }
}
