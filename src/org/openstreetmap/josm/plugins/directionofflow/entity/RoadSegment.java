/*
 *  Copyright 2015 Telenav, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.openstreetmap.josm.plugins.directionofflow.entity;

import java.util.List;
import org.openstreetmap.josm.data.coor.LatLon;


/**
 * Defines the attributes of a road segment.
 *
 * @author Beata
 * @version $Revision: 11 $
 */
public class RoadSegment {

    private final Long wayId;
    private final Long fromNodeId;
    private final Long toNodeId;
    private Integer numberOfTrips;
    private Double percentOfTrips;
    private ConfidenceLevel confidenceLevel;
    private List<LatLon> points;
    private Status status;
    private RoadType type;


    /**
     * Builds a new road segment with the given arguments.
     *
     * @param wayId the identifier of the OSM way which contains this segment
     * @param fromNodeId the identifier of the OSM node which marks the start of this road segment
     * @param toNodeId the identifier of the OSM node which marks the end of this road segment
     */
    public RoadSegment(final Long wayId, final Long fromNodeId, final Long toNodeId) {
        this.wayId = wayId;
        this.fromNodeId = fromNodeId;
        this.toNodeId = toNodeId;
    }

    /**
     * Builds a new road segment with the given arguments.
     *
     * @param wayId the identifier of the OSM way which contains this segment
     * @param fromNodeId the identifier of the OSM node which marks the start of this road segment
     * @param toNodeId the identifier of the OSM node which marks the end of this road segment
     * @param numberOfTrips the number of trips that passed through the road segment
     * @param confidenceLevel the measure of confidence with which this road segment is marked as one way
     * @param points the geometry of the segment, ordered in the direction of the one way restriction
     * @param status the status of the road segment
     * @param type the type of the OSM way which contains this road segment
     */
    public RoadSegment(final Long wayId, final Long fromNodeId, final Long toNodeId, final Integer numberOfTrips,
            final Double percentOfTrips, final ConfidenceLevel confidenceLevel, final List<LatLon> points,
            final Status status, final RoadType type) {
        this(wayId, fromNodeId, toNodeId);
        this.numberOfTrips = numberOfTrips;
        this.percentOfTrips = percentOfTrips;
        this.confidenceLevel = confidenceLevel;
        this.points = points;
        this.status = status;
        this.type = type;
    }


    public Long getWayId() {
        return wayId;
    }

    public Long getFromNodeId() {
        return fromNodeId;
    }

    public Long getToNodeId() {
        return toNodeId;
    }

    public Integer getNumberOfTrips() {
        return numberOfTrips;
    }

    public Double getPercentOfTrips() {
        return percentOfTrips;
    }

    public ConfidenceLevel getConfidenceLevel() {
        return confidenceLevel;
    }

    public List<LatLon> getPoints() {
        return points;
    }

    public Status getStatus() {
        return status;
    }

    public RoadType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((wayId == null) ? 0 : wayId.hashCode());
        result = prime * result + ((fromNodeId == null) ? 0 : fromNodeId.hashCode());
        result = prime * result + ((toNodeId == null) ? 0 : toNodeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        } else if (obj instanceof RoadSegment) {
            final RoadSegment other = (RoadSegment) obj;
            result = (wayId == null && other.getWayId() == null) || (wayId != null && wayId.equals(other.getWayId()));
            result = result && ((fromNodeId == null && other.getFromNodeId() == null)
                    || (fromNodeId != null && fromNodeId.equals(other.getFromNodeId())));
            result = result && ((toNodeId == null && other.getToNodeId() == null)
                    || (toNodeId != null && toNodeId.equals(other.getToNodeId())));
        }
        return result;
    }
}