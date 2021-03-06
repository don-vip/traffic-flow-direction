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
package org.openstreetmap.josm.plugins.directionofflow.gui.details;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.openstreetmap.josm.data.coor.LatLon;
import org.openstreetmap.josm.plugins.directionofflow.entity.Comment;


/**
 * Utility class, formats custom objects.
 *
 * @author Beata
 * @version $Revision: 47 $
 */
final class Formatter {

    private static final String DOUBLE_FORMAT = "0.00";
    private static final String TSTP = "yyyy-MM-dd HH:mm:ss";
    private static final Long UNIX_TSTP = 1000L;

    private Formatter() {}

    /**
     * Formats the given identifiers.
     *
     * @param wayId the way identifier of a road segment
     * @param fromId the from node identifier of a road segment
     * @param toId the to node identifier of a road segment
     * @return a string containing the given identifiers
     */
    static String formatIdentifier(final Long wayId, final Long fromId, final Long toId) {
        return wayId + "-" + fromId + "-" + toId;
    }

    /**
     * Formats the given double value using "0.00" format.
     *
     * @param value a double value
     * @param round if true the value is rounded
     * @return a string representation of the value
     */
    static String formatDouble(final Double value, final boolean round) {
        return value == null ? "" : (round ? "" + Math.round(value) : new DecimalFormat(DOUBLE_FORMAT).format(value));
    }

    static String formatLatLon(final LatLon latLon) {
        return latLon == null ? "" : latLon.getY() + "," + latLon.getX();
    }

    static String formatComments(final List<Comment> comments) {
        final StringBuilder sb = new StringBuilder("<html><body><font size='3' face='times new roman'>");
        for (final Comment comment : comments) {
            sb.append(("<b>"));
            sb.append(formatTimestamp(comment.getTimestamp()));
            sb.append(", ").append(comment.getUsername());
            sb.append("</b><br>");
            if (comment.getStatus() != null) {
                sb.append("changed status to ");
                sb.append(comment.getStatus());
                sb.append("<br>").append("with ");
            } else {
                sb.append("added ");
            }
            sb.append("comment: ").append(comment.getText());
            sb.append("<br>");
        }
        sb.append("</font></body></html>");
        return sb.toString();
    }

    private static String formatTimestamp(final Long timestamp) {
        final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(TSTP);
        dateTimeFormat.setTimeZone(TimeZone.getDefault());
        return timestamp != null ? dateTimeFormat.format(new Date(timestamp * UNIX_TSTP)) : "";
    }
}