package thirdstage.exercise.spring3.spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class DepositRequestSupport {
	
	/*
	 * SpelExpressionParser is thread-safe (documented in Javadoc)
	 */
	private ExpressionParser exprParser = new SpelExpressionParser();
	
	/**
	 * This method is thread-safe
	 * 
	 * @param req
	 * @param expr
	 * @return
	 */
	public boolean check(DepositRequest req, String expr){
		
		StandardEvaluationContext cntx = new StandardEvaluationContext(req);
		return this.exprParser.parseExpression(expr).getValue(cntx, Boolean.class);
	}
	

}
