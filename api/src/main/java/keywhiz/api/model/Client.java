/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package keywhiz.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.time.OffsetDateTime;
import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.nullToEmpty;

/** Clients table entry for a client-cert authenticated client. */
public class Client {
  @JsonProperty
  private final long id;

  @JsonProperty
  private final String name;

  @JsonProperty
  private final String description;

  @JsonProperty
  private final OffsetDateTime createdAt;

  @JsonProperty
  private final String createdBy;

  @JsonProperty
  private final OffsetDateTime updatedAt;

  @JsonProperty
  private final String updatedBy;

  /** True if client is enabled to retrieve secrets. */
  @JsonProperty
  private final boolean enabled;

  /** True if client is enabled to do automationAllowed tasks. */
  @JsonProperty
  private final boolean automationAllowed;

  public Client(@JsonProperty("id") long id,
      @JsonProperty("name") String name,
      @JsonProperty("description") @Nullable String description,
      @JsonProperty("createdAt") OffsetDateTime createdAt,
      @JsonProperty("createdBy") @Nullable String createdBy,
      @JsonProperty("updatedAt") OffsetDateTime updatedAt,
      @JsonProperty("updatedBy") @Nullable String updatedBy,
      @JsonProperty("enabled") boolean enabled,
      @JsonProperty("automationAllowed") boolean automationAllowed) {
    this.id = id;
    this.name = checkNotNull(name);
    this.description = nullToEmpty(description);
    this.createdAt = createdAt;
    this.createdBy = nullToEmpty(createdBy);
    this.updatedAt = updatedAt;
    this.updatedBy = nullToEmpty(updatedBy);
    this.enabled = enabled;
    this.automationAllowed = automationAllowed;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public boolean isAutomationAllowed() {
    return automationAllowed;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Client) {
      Client that = (Client) o;
      if (this.id == that.id &&
          Objects.equal(this.name, that.name) &&
          Objects.equal(this.description, that.description) &&
          Objects.equal(this.createdAt, that.createdAt) &&
          Objects.equal(this.createdBy, that.createdBy) &&
          Objects.equal(this.updatedAt, that.updatedAt) &&
          Objects.equal(this.updatedBy, that.updatedBy) &&
          this.enabled == that.enabled &&
          this.automationAllowed == that.automationAllowed) {
        return true;
      }
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, name, description, createdAt, createdBy, updatedAt, updatedBy,
        enabled, automationAllowed);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("name", name)
        .add("description", description)
        .add("createdAt", createdAt)
        .add("createdBy", createdBy)
        .add("updatedAt", updatedAt)
        .add("updatedBy", updatedBy)
        .add("enabled", enabled)
        .add("automationAllowed", automationAllowed)
        .toString();
  }
}
