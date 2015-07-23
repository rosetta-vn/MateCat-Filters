package com.matecat.converter.core.okapiclient;

import com.matecat.converter.core.format.Format;
import junit.framework.Assert;
import net.sf.okapi.common.filters.IFilter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Reneses on 7/23/15.
 */
public class OkapiFilterFactoryTest {

    /**
     * Check that the list of supported formats and the filters available
     * are synchronized.
     */
    @Test
    public void testFormatsSynchronized() throws Exception {

        Arrays.stream(Format.values()).forEach(
                format -> {

                    boolean supported = OkapiFilterFactory.isSupported(format);

                    try {
                        OkapiFilterFactory.getFilter(format);
                        if (!supported)
                            Assert.fail("The format " + format + " is no synchronized");
                    }
                    catch (Exception e) {
                        if (supported)
                            Assert.fail("The format " + format + " is no synchronized");
                    }
                });
    }
}