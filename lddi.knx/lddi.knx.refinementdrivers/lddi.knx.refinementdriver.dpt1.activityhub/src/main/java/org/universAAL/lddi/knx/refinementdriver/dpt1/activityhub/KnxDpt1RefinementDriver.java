/*
     Copyright 2010-2014 AIT Austrian Institute of Technology GmbH
	 http://www.ait.ac.at

     See the NOTICE file distributed with this work for additional
     information regarding copyright ownership

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
*/

package org.universAAL.lddi.knx.refinementdriver.dpt1.activityhub;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.device.Constants;
import org.osgi.service.device.Device;
import org.osgi.service.device.Driver;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;
import org.universAAL.lddi.lib.activityhub.devicecategory.ActivityHubDeviceCategoryUtil.ActivityHubDeviceCategory;
import org.universAAL.lddi.lib.activityhub.knxmapping.KnxMappingFactory;
import org.universAAL.lddi.knx.groupdevicecategory.IKnxDpt1;
import org.universAAL.lddi.knx.groupdevicecategory.KnxGroupDeviceCategoryUtil;
import org.universAAL.lddi.knx.groupdevicecategory.KnxGroupDeviceCategoryUtil.KnxGroupDeviceCategory;
import org.universAAL.lddi.knx.groupdevicemodel.KnxDpt1GroupDevice;

/**
 * checks device references coming from OSGi DeviceManager; matching KNX
 * groupDevice category attaches exactly one driver instance per deviceId (first
 * groupDevice) subsequent devices with the same deviceId are rejected!
 *
 * when an attached groupDevice service is unregistered: drivers must take the
 * appropriate action to release this groupDevice service and peform any
 * necessary cleanup, as described in their groupDevice category spec
 *
 * Initially a manual mapping config from KNX to ISO sensors were implemented.
 * But in universAAL this configuration should be done by Space
 * configurator. Therefore this code is commented; but kept here for potential
 * later use.
 *
 * @author Thomas Fuxreiter (foex@gmx.at)
 */
public class KnxDpt1RefinementDriver implements Driver
// , ServiceTrackerCustomizer
// , ManagedService
// , ManagedServiceFactory
{

	private BundleContext context;
	private LogService logger;
	private static final String MY_DRIVER_ID = "org.universAAL.knx.dpt1.0.0.1"; // "Knx_DoorWindowActuator"
	// private static final String MY_KNX_DEVICE_CATEGORY = "IKnxDpt1";
	private static final KnxGroupDeviceCategory MY_KNX_DEVICE_CATEGORY = KnxGroupDeviceCategory.KNX_DPT_1;

	// private static final String KNX_DRIVER_CONFIG_NAME =
	// "knx.dpt1refinementdriver.iso11073";

	// String filterQuery=String.format("(%s=%s)",
	// org.osgi.framework.Constants.OBJECTCLASS,IKnxNetwork.class.getName());
	// private IKnxNetwork network;

	/** Set of all DPT1 drivers registered here */
	// private Set<KnxDpt1Instance> connectedDriver;

	// private Dictionary<String,String> knxIsoMappingProperties;

	// private ServiceRegistration myManagedServiceRegistration;
	// private ServiceRegistration myDriverRegistration;

	// /**
	// * Key is the PID created dynamically from Configuration Admin
	// * Value are the configuration properties stored in KnxDeviceConfig class
	// */
	// private final Map<String, KnxDeviceConfig> configurationMap =
	// new ConcurrentHashMap<String, KnxDeviceConfig>();

	/**
	 * Key is groupAddress of the KNX groupDevice Value is the associated driver
	 */
	private final Map<String, KnxDpt1Instance> connectedDriverInstanceMap = new ConcurrentHashMap<String, KnxDpt1Instance>();

	/**
	 * @param context
	 * @param logTracker
	 */
	public KnxDpt1RefinementDriver(BundleContext context, LogService log) {
		this.context = context;
		this.logger = log;

		// this.registerManagedService();
		this.registerDriver();
	}

	// /**
	// * Register this class as Managed Service Factory
	// */
	// public void registerManagedService() {
	//// this.logger.log(LogService.LOG_ERROR, "Register managed service!");
	//
	// Properties propManagedService=new Properties();
	// propManagedService.put(org.osgi.framework.Constants.SERVICE_PID,
	// KNX_DRIVER_CONFIG_NAME);
	//
	// // register ManagedServiceFactory
	// this.myManagedServiceRegistration =
	// this.context.registerService(ManagedServiceFactory.class.getName(),
	// this, propManagedService);
	//
	// // register ManagedService
	// //this.context.registerService(ManagedService.class.getName(), this,
	// propManagedService);
	// }

	/** register this driver in OSGi */
	private void registerDriver() {
		Properties propDriver = new Properties();
		propDriver.put(Constants.DRIVER_ID, MY_DRIVER_ID);
		// this.myDriverRegistration =
		this.context.registerService(Driver.class.getName(), this, propDriver);
	}

	// /**
	// * @see
	// org.osgi.service.cm.ManagedServiceFactory#updated(java.lang.String,
	// java.util.Dictionary)
	// *
	// * update method from ManagedServiceFactory
	// * is called extra for every config in the factory
	// * the pid is generated by ConfigAdmin
	// */
	// public void updated(String pid, Dictionary properties)
	// throws ConfigurationException {
	// this.logger.log(LogService.LOG_INFO, "KnxDpt1Driver updated for driver
	// instance " + pid +
	// ". Mapping properties from KNX groupDevice to ISO 11073 groupDevice: " +
	// properties);
	//
	// if (properties != null) {
	// // properties.get("isoDeviceType");
	// // properties.get("deviceNature");
	// // properties.get("deviceType");
	//
	// String knxAddress = (String) properties.get("knxGroupAddress");
	// //String newKnxAddress = knxAddress.replace('-', '/');
	// // update knxGroupAddress value
	// //properties.put("knxGroupAddress", newKnxAddress);
	//
	// // create new knx groupDevice config
	// KnxDeviceConfig knxDevConf = new KnxDeviceConfig(knxAddress, properties,
	// pid);
	//
	// // update configuration map
	// this.configurationMap.put(pid, knxDevConf);
	//
	// // update driver instance if there is one already
	// KnxDpt1Instance instance = this.connectedDriverInstanceMap.get(pid);
	// if ( instance != null ) {
	// if ( instance.updateConfiguration(properties) ) {
	// this.logger.log(LogService.LOG_INFO, "Successfully updated configuration
	// of driver instance " + pid);
	// } else {
	// this.logger.log(LogService.LOG_ERROR, "Error on updating configuration of
	// driver instance " + pid);
	// }
	// } else {
	// // new instances are created after a groupDevice reference appears; in
	// attach method
	// }
	// } else {
	// // if there are no properties for a specific pid it should be deleted !?
	//
	// KnxDpt1Instance instance = this.connectedDriverInstanceMap.get(pid);
	// instance.detachDriver();
	// this.connectedDriverInstanceMap.remove(pid);
	//
	// // delete configuration
	// this.configurationMap.remove(pid);
	//
	// this.logger.log(LogService.LOG_INFO, "Driver instance and associated
	// objects for " +
	// pid + " destroyed!");
	// }
	// }

	/**
	 * called from OSGI DeviceManager check device services if they have
	 * identical device_category as this driver
	 *
	 * @see org.osgi.service.device.Driver#match(org.osgi.framework.ServiceReference)
	 */
	public int match(ServiceReference reference) throws Exception {
		// reference = groupDevice service
		int matchValue = Device.MATCH_NONE;
		// String groupDeviceCategory = null;
		KnxGroupDeviceCategory groupDeviceCategory = null;

		try {
			groupDeviceCategory = KnxGroupDeviceCategoryUtil
					.getCategory((String) reference.getProperty(Constants.DEVICE_CATEGORY));
		} catch (ClassCastException e) {
			this.logger.log(LogService.LOG_DEBUG, "Could not cast DEVICE_CATEGORY of requesting" + " device service "
					+ reference.getProperty(org.osgi.framework.Constants.SERVICE_ID) + " to String. No match!");
			return matchValue;
		}

		// match check
		// more possible properties to match: description, serial, id
		if (groupDeviceCategory == MY_KNX_DEVICE_CATEGORY) {
			matchValue = IKnxDpt1.MATCH_CLASS;
		} else {
			this.logger.log(LogService.LOG_DEBUG,
					"Requesting device service " + groupDeviceCategory + " doesn't match with driver. No match!");
		}

		return matchValue; // must be > 0 to match
	}

	/**
	 * @see org.osgi.service.device.Driver#attach(org.osgi.framework.ServiceReference)
	 *      attach the device service reference to a "driving" instance; couple
	 *      them
	 */
	public String attach(ServiceReference reference) throws Exception {

		// get groupAddress
		KnxDpt1GroupDevice knxDev = (KnxDpt1GroupDevice) this.context.getService(reference);

		if (this.connectedDriverInstanceMap.containsKey(knxDev.getGroupAddress())) {
			this.logger.log(LogService.LOG_WARNING, "There is already a driver instance available for "
					+ " the groupDevice " + knxDev.getGroupAddress());
			return "driver already exists for this groupDevice!";
		}

		// mapping from knx dpt to iso sensor type should be done automatically
		// without configuration
		//
		// KnxDeviceConfig knxDevConf =
		// findConfiguration(knxDev.getGroupAddress());
		//
		// // exit if there is no configuration for this group address
		// if ( knxDevConf == null ) {
		// this.logger.log(LogService.LOG_WARNING, "no KNX to ISO mapping
		// configuration found " +
		// "for " + knxDev.getGroupAddress());
		// return "no configuration found!";
		// }

		ActivityHubDeviceCategory ahDevCat = KnxMappingFactory.getAHDevCatForKnxDpt(knxDev.getDatapointTypeMainNumber(),
				knxDev.getDatapointTypeSubNumber());
		if (ahDevCat == null) {
			this.logger.log(LogService.LOG_WARNING,
					"There is no mapping KnxGroupDeviceCategory found " + "for the KNX groupDevice "
							+ knxDev.getGroupAddress() + " with datapoint type " + knxDev.getDatapointType());
			return "no mapping KnxGroupDeviceCategory found!";
		}

		// create "driving" instance
		KnxDpt1Instance instance = new KnxDpt1Instance(this.context, this.logger, ahDevCat);

		// pass knx-to-iso config
		// instance.setKnxIsoMappingProperties(this.knxIsoMappingProperties);
		// instance.setKnxIsoMappingProperties(knxDevConf.getConfigurationProperties());

		// store instance
		this.connectedDriverInstanceMap.put(knxDev.getGroupAddress(), instance);

		// init service tracker; the driver instance itself tracks on the device
		// reference!
		ServiceTracker tracker = new ServiceTracker(this.context, reference, instance);
		tracker.open();

		return null; // if attachment is correct
	}

	// /** helper method
	// * finds configuration previously injected by ConfigAdmin for a specific
	// knx groupAddress
	// * in the field configurationMap
	// * @param knx groupAddress (1/2/3)
	// * @return null if no config found
	// */
	// private KnxDeviceConfig findConfiguration(String knxGA) {
	// for ( Iterator<KnxDeviceConfig> iter =
	// this.configurationMap.values().iterator(); iter.hasNext(); ) {
	// KnxDeviceConfig knxDevConf = iter.next();
	// if ( knxDevConf.getKnxGroupAddress().equals(knxGA) ) {
	// return knxDevConf;
	// }
	// }
	// return null;
	// }

	/**
	 * delete instance references unregister my services ?
	 */
	public void stop() {

		// delete instance references !!
		for (Iterator<KnxDpt1Instance> it = this.connectedDriverInstanceMap.values().iterator(); it.hasNext();) {
			it.next().detachDriver();
		}

		// the managed service and driver service is unregistered automatically
		// by the OSGi framework!
	}

	// /* (non-Javadoc)
	// * @see
	// org.osgi.service.cm.ManagedServiceFactory#deleted(java.lang.String)
	// */
	// public void deleted(String pid) {
	//
	// KnxDpt1Instance instance = this.connectedDriverInstanceMap.get(pid);
	// instance.detachDriver();
	// this.connectedDriverInstanceMap.remove(pid);
	//
	// // delete configuration
	// this.configurationMap.remove(pid);
	//
	// this.logger.log(LogService.LOG_INFO, "Driver instance and associated
	// objects for " +
	// pid + " destroyed!");
	// }

	// /* (non-Javadoc)
	// * @see org.osgi.service.cm.ManagedServiceFactory#getName()
	// */
	// public String getName() {
	// return "Configuration Factory for KNX devices with data point type 1; " +
	// "Mapping parameters for ISO11073 devices";
	// }

	// /* (non-Javadoc)
	// * @see org.osgi.service.cm.ManagedService#updated(java.util.Dictionary)
	// *
	// * update method from ManagedService
	// */
	// public void updated(Dictionary properties) throws ConfigurationException
	// {
	// this.logger.log(LogService.LOG_INFO, "KnxDpt1Driver updated. " +
	// "Mapping from KNX groupDevice to ISO 11073 groupDevice. " + properties);
	//
	// if (properties != null) {
	// this.knxIsoMappingProperties = new Properties();
	//
	// /** groupAddress configuration format is "A-B-C" because Felix
	// ConfigurationManager says '/' is an illegal character;
	// * change here to "A/B/C" */
	// Enumeration<String> en = properties.keys();
	// while (en.hasMoreElements()) {
	// String key = en.nextElement();
	// String newKey = key.replace('-', '/');
	//
	// String value = (String) properties.get(key);
	// this.knxIsoMappingProperties.put(newKey, value);
	// }
	// this.logger.log(LogService.LOG_INFO, "KNX-ISO mapping config: " +
	// this.knxIsoMappingProperties);
	// } else {
	// this.logger.log(LogService.LOG_ERROR, "No configuration found for Knx to
	// ISO groupDevice mapping!");
	// return;
	// }
	// }

}
