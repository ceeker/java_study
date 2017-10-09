package com.ceeker.app.study.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.0.1)",
        comments = "Source: user.proto")
public class UserServiceGrpc {

    public static final String SERVICE_NAME = "com.ceeker.app.study.proto.UserService";
    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.ceeker.app.study.proto.UserDO.GetAddressBookReq,
            com.ceeker.app.study.proto.UserDO.GetAddressBookRsp> METHOD_GET_USER =
            io.grpc.MethodDescriptor.create(
                    io.grpc.MethodDescriptor.MethodType.UNARY,
                    generateFullMethodName(
                            "com.ceeker.app.study.proto.UserService", "getUser"),
                    io.grpc.protobuf.ProtoUtils.marshaller(com.ceeker.app.study.proto.UserDO.GetAddressBookReq.getDefaultInstance()),
                    io.grpc.protobuf.ProtoUtils.marshaller(com.ceeker.app.study.proto.UserDO.GetAddressBookRsp.getDefaultInstance()));
    private static final int METHODID_GET_USER = 0;

    private UserServiceGrpc() {
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static UserServiceStub newStub(io.grpc.Channel channel) {
        return new UserServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static UserServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new UserServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
     */
    public static UserServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new UserServiceFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        return new io.grpc.ServiceDescriptor(SERVICE_NAME,
                METHOD_GET_USER);
    }

    /**
     */
    public static abstract class UserServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * 根据用户id获取AddressBook
         * </pre>
         */
        public void getUser(com.ceeker.app.study.proto.UserDO.GetAddressBookReq request,
                            io.grpc.stub.StreamObserver<com.ceeker.app.study.proto.UserDO.GetAddressBookRsp> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_USER, responseObserver);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            METHOD_GET_USER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.ceeker.app.study.proto.UserDO.GetAddressBookReq,
                                            com.ceeker.app.study.proto.UserDO.GetAddressBookRsp>(
                                            this, METHODID_GET_USER)))
                    .build();
        }
    }

    /**
     */
    public static final class UserServiceStub extends io.grpc.stub.AbstractStub<UserServiceStub> {
        private UserServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserServiceStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected UserServiceStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            return new UserServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * 根据用户id获取AddressBook
         * </pre>
         */
        public void getUser(com.ceeker.app.study.proto.UserDO.GetAddressBookReq request,
                            io.grpc.stub.StreamObserver<com.ceeker.app.study.proto.UserDO.GetAddressBookRsp> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_USER, getCallOptions()), request, responseObserver);
        }
    }

    /**
     */
    public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractStub<UserServiceBlockingStub> {
        private UserServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserServiceBlockingStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected UserServiceBlockingStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new UserServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * 根据用户id获取AddressBook
         * </pre>
         */
        public com.ceeker.app.study.proto.UserDO.GetAddressBookRsp getUser(com.ceeker.app.study.proto.UserDO.GetAddressBookReq request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_USER, getCallOptions(), request);
        }
    }

    /**
     */
    public static final class UserServiceFutureStub extends io.grpc.stub.AbstractStub<UserServiceFutureStub> {
        private UserServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private UserServiceFutureStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected UserServiceFutureStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new UserServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * 根据用户id获取AddressBook
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.ceeker.app.study.proto.UserDO.GetAddressBookRsp> getUser(
                com.ceeker.app.study.proto.UserDO.GetAddressBookReq request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_USER, getCallOptions()), request);
        }
    }

    private static class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserServiceImplBase serviceImpl;
        private final int methodId;

        public MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_GET_USER:
                    serviceImpl.getUser((com.ceeker.app.study.proto.UserDO.GetAddressBookReq) request,
                            (io.grpc.stub.StreamObserver<com.ceeker.app.study.proto.UserDO.GetAddressBookRsp>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

}
