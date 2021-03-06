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
package org.openstreetmap.josm.plugins.directionofflow.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JDialog;
import org.openstreetmap.josm.Main;


/**
 *
 * @author Beata
 * @version $Revision: 11 $
 */
public abstract class ModalDialog extends JDialog {

    private static final long serialVersionUID = 9216123763742292767L;

    /**
     * Builds a new {@code ModalDialog} with the given arguments.
     *
     * @param title the dialog title
     * @param icon the icon to be displayed in the dialog header
     */
    public ModalDialog(final String title, final Image icon) {
        setLayout(new BorderLayout());
        setModal(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(Main.map.mapView);
        setTitle(title);
        setIconImage(icon);
    }

    /**
     * Builds a new {@code ModalDialog} with the given arguments.
     *
     * @param title the dialog title
     * @param icon the icon to be displayed in the dialog header
     * @param size the size of the dialog
     */
    public ModalDialog(final String title, final Image icon, final Dimension size) {
        this(title, icon);
        setSize(size);
        setMinimumSize(size);
    }

    /**
     * Creates the UI components.
     */
    protected abstract void createComponents();
}