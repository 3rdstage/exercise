package thirdstage.exercise.spring3.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ObjectInspector {
	
	// SpelExpressionParser is thread-safe which is explicitly documented in API doc.
	private ExpressionParser expressionParser = new SpelExpressionParser();

	/**
	 * Evaluate the given boolean expression against the specified object.<br/>
	 * This method is thread-safe. 
	 *  
	 * @param obj object to check
	 * @param booleanExpr boolean expression to evaluate which should be valid with SpEL
	 * @param clazz the type of the <code>obj</code>
	 */
	public <T> boolean checkBooleanExpression(T obj, String booleanExpr, Class<T> clazz){

		StandardEvaluationContext cntx = new StandardEvaluationContext(obj);
		return this.expressionParser.parseExpression(booleanExpr).getValue(cntx, Boolean.class);		
	}
}
