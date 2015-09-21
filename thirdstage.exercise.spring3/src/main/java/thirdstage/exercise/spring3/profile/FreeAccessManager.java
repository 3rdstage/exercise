/**
 *
 */
package thirdstage.exercise.spring3.profile;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author 3rdstage
 * @version
 * @since
 *
 */
public class FreeAccessManager implements AccessManager {

	/* (non-Javadoc)
	 * @see thirdstage.exercise.spring3.profile.AccessManager#validate(thirdstage.exercise.spring3.profile.Session)
	 */
	@Override
	public boolean validate(Session sess) {
		// TODO Auto-generated method stub
		return false;
	}

}
