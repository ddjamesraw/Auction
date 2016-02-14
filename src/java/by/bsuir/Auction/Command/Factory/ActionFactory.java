/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command.Factory;

import by.bsuir.Auction.Command.Command;
import by.bsuir.Auction.Command.ActionEnum;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DDJames
 */
public class ActionFactory {
    private static final String PARAM_ACTION = "action";

	public Command defineAction(HttpServletRequest request) {
		String[] actionStringArray = request.getParameterValues(PARAM_ACTION);
		String actionString = null;
		if (actionStringArray != null) {
			actionString = actionStringArray[0];
		}
		Command abstractAction = ActionEnum.MAIN.getAction();

		if (actionString != null) {
			try {
				ActionEnum actionEnum = ActionEnum.valueOf(actionString.toUpperCase());
				abstractAction = actionEnum.getAction();
				
			} catch (IllegalArgumentException e) {
				//!!!
			}
		}

		return abstractAction;
	}
}
