import play.mvc.EssentialFilter;
import play.filters.cors.CORSFilter;
import play.http.DefaultHttpFilters;

import javax.inject.Inject;

/**
 * The type Filters.
 */
public class Filters extends DefaultHttpFilters {

    /**
     * Instantiates a new Filters.
     *
     * @param corsFilter the cors filter
     */
    @Inject public Filters(CORSFilter corsFilter) {
       super(corsFilter);
    }
}