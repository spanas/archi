/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package uk.ac.bolton.archimate.editor.diagram.editparts.business;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;

import uk.ac.bolton.archimate.editor.diagram.editparts.AbstractArchimateEditableTextFlowEditPart;
import uk.ac.bolton.archimate.editor.diagram.editparts.OrthogonalAnchor;
import uk.ac.bolton.archimate.editor.diagram.figures.business.BusinessValueFigure;
import uk.ac.bolton.archimate.editor.preferences.IPreferenceConstants;
import uk.ac.bolton.archimate.editor.preferences.Preferences;

/**
 * Business Value Edit Part
 * 
 * @author Phillip Beauvoir
 */
public class BusinessValueEditPart
extends AbstractArchimateEditableTextFlowEditPart {
    
    @Override
    protected IFigure createFigure() {
        return new BusinessValueFigure(getModel());
    }
 
    @Override
    protected ConnectionAnchor getDefaultConnectionAnchor() {
        if(fDefaultConnectionAnchor == null) {
            fDefaultConnectionAnchor = new EllipseAnchor(getFigure());
        }
        return fDefaultConnectionAnchor;
    }

    @Override
    protected ConnectionAnchor getConnectionAnchor(ConnectionEditPart connection) {
        if(Preferences.STORE.getBoolean(IPreferenceConstants.USE_ORTHOGONAL_ANCHOR)) {
            if(fActiveConnectionAnchor == null) {
                fActiveConnectionAnchor = new OrthogonalAnchor(this, connection);
            }
            return fActiveConnectionAnchor;
        }
        
        return getDefaultConnectionAnchor();
    }
}