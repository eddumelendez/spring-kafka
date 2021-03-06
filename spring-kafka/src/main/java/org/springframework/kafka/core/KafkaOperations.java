/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.kafka.core;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * The basic Kafka operations contract.
 *
 * @param <K> the key type.
 * @param <V> the value type.
 *
 * @author Marius Bogoevici
 * @author Gary Russell
 */
public interface KafkaOperations<K, V> {

	// Async methods

	/**
	 * Send the data to the default topic with no key or partition.
	 * @param data The data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(V data);

	/**
	 * Send the data to the default topic with the provided key and no partition.
	 * @param key the key.
	 * @param data The data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(K key, V data);

	/**
	 * Send the data to the default topic with the provided key and partition.
	 * @param partition the partition.
	 * @param key the key.
	 * @param data the data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(int partition, K key, V data);

	/**
	 * Send the data to the provided topic with no key or partition.
	 * @param topic the topic.
	 * @param data The data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(String topic, V data);

	/**
	 * Send the data to the provided topic with the provided key and no partition.
	 * @param topic the topic.
	 * @param key the key.
	 * @param data The data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(String topic, K key, V data);

	/**
	 * Send the data to the provided topic with the provided key and partition.
	 * @param topic the topic.
	 * @param partition the partition.
	 * @param key the key.
	 * @param data the data.
	 * @return a Future for the {@link RecordMetadata}.
	 */
	Future<RecordMetadata> convertAndSend(String topic, int partition, K key, V data);


	// Sync methods


	/**
	 * Send the data to the default topic with no key or partition;
	 * wait for result.
	 * @param data The data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(V data) throws InterruptedException, ExecutionException;

	/**
	 * Send the data to the default topic with the provided key and no partition;
	 * wait for result.
	 * @param key the key.
	 * @param data The data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(K key, V data) throws InterruptedException, ExecutionException;

	/**
	 * Send the data to the default topic with the provided key and partition.
	 * wait for result.
	 * @param partition the partition.
	 * @param key the key.
	 * @param data the data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(int partition, K key, V data) throws InterruptedException, ExecutionException;

	/**
	 * Send the data to the provided topic with no key or partition.;
	 * wait for result.
	 * @param topic the topic.
	 * @param data The data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(String topic, V data) throws InterruptedException, ExecutionException;

	/**
	 * Send the data to the provided topic with the provided key and no partition;
	 * wait for result.
	 * @param topic the topic.
	 * @param key the key.
	 * @param data The data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(String topic, K key, V data) throws InterruptedException, ExecutionException;

	/**
	 * Send the data to the provided topic with the provided key and partition;
	 * wait for result.
	 * @param topic the topic.
	 * @param partition the partition.
	 * @param key the key.
	 * @param data the data.
	 * @return a {@link RecordMetadata}.
	 * @throws ExecutionException execution exception while awaiting result.
	 * @throws InterruptedException thread interrupted while awaiting result.
	 */
	RecordMetadata syncConvertAndSend(String topic, int partition, K key, V data)
		throws InterruptedException, ExecutionException;

	/**
	 * Flush the producer.
	 */
	void flush();

}
