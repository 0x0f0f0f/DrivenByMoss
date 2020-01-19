// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2020
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.bitwig.framework.configuration;

import de.mossgrabers.framework.configuration.IEnumSetting;
import de.mossgrabers.framework.observer.IValueObserver;

import com.bitwig.extension.controller.api.SettableEnumValue;
import com.bitwig.extension.controller.api.Setting;


/**
 * Bitwig implementation of an enum setting.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class EnumSettingImpl extends AbstractSetting<String> implements IEnumSetting
{
    private SettableEnumValue enumValue;


    /**
     * Constructor.
     *
     * @param enumValue The enum value
     */
    public EnumSettingImpl (final SettableEnumValue enumValue)
    {
        super ((Setting) enumValue);

        this.enumValue = enumValue;
    }


    /** {@inheritDoc} */
    @Override
    public void set (final String value)
    {
        this.enumValue.set (value);
    }


    /** {@inheritDoc} */
    @Override
    public void addValueObserver (final IValueObserver<String> observer)
    {
        this.enumValue.addValueObserver (observer::update);

        // Directly fire the current value
        observer.update (this.enumValue.get ());
    }
}
