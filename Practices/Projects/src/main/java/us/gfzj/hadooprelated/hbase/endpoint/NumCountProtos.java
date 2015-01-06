package us.gfzj.hadooprelated.hbase.endpoint;

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: NumCount.proto

public final class NumCountProtos {
  private NumCountProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface NumCountRequestOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 sex = 1;
    /**
     * <code>required int32 sex = 1;</code>
     */
    boolean hasSex();
    /**
     * <code>required int32 sex = 1;</code>
     */
    int getSex();
  }
  /**
   * Protobuf type {@code NumCountRequest}
   */
  public static final class NumCountRequest extends
      com.google.protobuf.GeneratedMessage
      implements NumCountRequestOrBuilder {
    // Use NumCountRequest.newBuilder() to construct.
    private NumCountRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private NumCountRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final NumCountRequest defaultInstance;
    public static NumCountRequest getDefaultInstance() {
      return defaultInstance;
    }

    public NumCountRequest getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private NumCountRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              sex_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return NumCountProtos.internal_static_NumCountRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return NumCountProtos.internal_static_NumCountRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NumCountProtos.NumCountRequest.class, NumCountProtos.NumCountRequest.Builder.class);
    }

    public static com.google.protobuf.Parser<NumCountRequest> PARSER =
        new com.google.protobuf.AbstractParser<NumCountRequest>() {
      public NumCountRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new NumCountRequest(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<NumCountRequest> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 sex = 1;
    public static final int SEX_FIELD_NUMBER = 1;
    private int sex_;
    /**
     * <code>required int32 sex = 1;</code>
     */
    public boolean hasSex() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 sex = 1;</code>
     */
    public int getSex() {
      return sex_;
    }

    private void initFields() {
      sex_ = 0;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasSex()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, sex_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, sex_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static NumCountProtos.NumCountRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static NumCountProtos.NumCountRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static NumCountProtos.NumCountRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static NumCountProtos.NumCountRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static NumCountProtos.NumCountRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static NumCountProtos.NumCountRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static NumCountProtos.NumCountRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static NumCountProtos.NumCountRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static NumCountProtos.NumCountRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static NumCountProtos.NumCountRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(NumCountProtos.NumCountRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code NumCountRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements NumCountProtos.NumCountRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return NumCountProtos.internal_static_NumCountRequest_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return NumCountProtos.internal_static_NumCountRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                NumCountProtos.NumCountRequest.class, NumCountProtos.NumCountRequest.Builder.class);
      }

      // Construct using NumCountProtos.NumCountRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        sex_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return NumCountProtos.internal_static_NumCountRequest_descriptor;
      }

      public NumCountProtos.NumCountRequest getDefaultInstanceForType() {
        return NumCountProtos.NumCountRequest.getDefaultInstance();
      }

      public NumCountProtos.NumCountRequest build() {
        NumCountProtos.NumCountRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public NumCountProtos.NumCountRequest buildPartial() {
        NumCountProtos.NumCountRequest result = new NumCountProtos.NumCountRequest(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.sex_ = sex_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof NumCountProtos.NumCountRequest) {
          return mergeFrom((NumCountProtos.NumCountRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(NumCountProtos.NumCountRequest other) {
        if (other == NumCountProtos.NumCountRequest.getDefaultInstance()) return this;
        if (other.hasSex()) {
          setSex(other.getSex());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasSex()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        NumCountProtos.NumCountRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (NumCountProtos.NumCountRequest) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 sex = 1;
      private int sex_ ;
      /**
       * <code>required int32 sex = 1;</code>
       */
      public boolean hasSex() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 sex = 1;</code>
       */
      public int getSex() {
        return sex_;
      }
      /**
       * <code>required int32 sex = 1;</code>
       */
      public Builder setSex(int value) {
        bitField0_ |= 0x00000001;
        sex_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 sex = 1;</code>
       */
      public Builder clearSex() {
        bitField0_ = (bitField0_ & ~0x00000001);
        sex_ = 0;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:NumCountRequest)
    }

    static {
      defaultInstance = new NumCountRequest(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:NumCountRequest)
  }

  public interface NumCountResponseOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int64 count = 1;
    /**
     * <code>required int64 count = 1;</code>
     */
    boolean hasCount();
    /**
     * <code>required int64 count = 1;</code>
     */
    long getCount();
  }
  /**
   * Protobuf type {@code NumCountResponse}
   */
  public static final class NumCountResponse extends
      com.google.protobuf.GeneratedMessage
      implements NumCountResponseOrBuilder {
    // Use NumCountResponse.newBuilder() to construct.
    private NumCountResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private NumCountResponse(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final NumCountResponse defaultInstance;
    public static NumCountResponse getDefaultInstance() {
      return defaultInstance;
    }

    public NumCountResponse getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private NumCountResponse(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              count_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return NumCountProtos.internal_static_NumCountResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return NumCountProtos.internal_static_NumCountResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              NumCountProtos.NumCountResponse.class, NumCountProtos.NumCountResponse.Builder.class);
    }

    public static com.google.protobuf.Parser<NumCountResponse> PARSER =
        new com.google.protobuf.AbstractParser<NumCountResponse>() {
      public NumCountResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new NumCountResponse(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<NumCountResponse> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int64 count = 1;
    public static final int COUNT_FIELD_NUMBER = 1;
    private long count_;
    /**
     * <code>required int64 count = 1;</code>
     */
    public boolean hasCount() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int64 count = 1;</code>
     */
    public long getCount() {
      return count_;
    }

    private void initFields() {
      count_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasCount()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt64(1, count_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, count_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static NumCountProtos.NumCountResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static NumCountProtos.NumCountResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static NumCountProtos.NumCountResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static NumCountProtos.NumCountResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static NumCountProtos.NumCountResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static NumCountProtos.NumCountResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static NumCountProtos.NumCountResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static NumCountProtos.NumCountResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static NumCountProtos.NumCountResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static NumCountProtos.NumCountResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(NumCountProtos.NumCountResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code NumCountResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements NumCountProtos.NumCountResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return NumCountProtos.internal_static_NumCountResponse_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return NumCountProtos.internal_static_NumCountResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                NumCountProtos.NumCountResponse.class, NumCountProtos.NumCountResponse.Builder.class);
      }

      // Construct using NumCountProtos.NumCountResponse.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        count_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return NumCountProtos.internal_static_NumCountResponse_descriptor;
      }

      public NumCountProtos.NumCountResponse getDefaultInstanceForType() {
        return NumCountProtos.NumCountResponse.getDefaultInstance();
      }

      public NumCountProtos.NumCountResponse build() {
        NumCountProtos.NumCountResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public NumCountProtos.NumCountResponse buildPartial() {
        NumCountProtos.NumCountResponse result = new NumCountProtos.NumCountResponse(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.count_ = count_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof NumCountProtos.NumCountResponse) {
          return mergeFrom((NumCountProtos.NumCountResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(NumCountProtos.NumCountResponse other) {
        if (other == NumCountProtos.NumCountResponse.getDefaultInstance()) return this;
        if (other.hasCount()) {
          setCount(other.getCount());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasCount()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        NumCountProtos.NumCountResponse parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (NumCountProtos.NumCountResponse) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int64 count = 1;
      private long count_ ;
      /**
       * <code>required int64 count = 1;</code>
       */
      public boolean hasCount() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int64 count = 1;</code>
       */
      public long getCount() {
        return count_;
      }
      /**
       * <code>required int64 count = 1;</code>
       */
      public Builder setCount(long value) {
        bitField0_ |= 0x00000001;
        count_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 count = 1;</code>
       */
      public Builder clearCount() {
        bitField0_ = (bitField0_ & ~0x00000001);
        count_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:NumCountResponse)
    }

    static {
      defaultInstance = new NumCountResponse(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:NumCountResponse)
  }

  /**
   * Protobuf service {@code NumCountService}
   */
  public static abstract class NumCountService
      implements com.google.protobuf.Service {
    protected NumCountService() {}

    public interface Interface {
      /**
       * <code>rpc getNumCount(.NumCountRequest) returns (.NumCountResponse);</code>
       */
      public abstract void getNumCount(
          com.google.protobuf.RpcController controller,
          NumCountProtos.NumCountRequest request,
          com.google.protobuf.RpcCallback<NumCountProtos.NumCountResponse> done);

    }

    public static com.google.protobuf.Service newReflectiveService(
        final Interface impl) {
      return new NumCountService() {
        @java.lang.Override
        public  void getNumCount(
            com.google.protobuf.RpcController controller,
            NumCountProtos.NumCountRequest request,
            com.google.protobuf.RpcCallback<NumCountProtos.NumCountResponse> done) {
          impl.getNumCount(controller, request, done);
        }

      };
    }

    public static com.google.protobuf.BlockingService
        newReflectiveBlockingService(final BlockingInterface impl) {
      return new com.google.protobuf.BlockingService() {
        public final com.google.protobuf.Descriptors.ServiceDescriptor
            getDescriptorForType() {
          return getDescriptor();
        }

        public final com.google.protobuf.Message callBlockingMethod(
            com.google.protobuf.Descriptors.MethodDescriptor method,
            com.google.protobuf.RpcController controller,
            com.google.protobuf.Message request)
            throws com.google.protobuf.ServiceException {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.callBlockingMethod() given method descriptor for " +
              "wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return impl.getNumCount(controller, (NumCountProtos.NumCountRequest)request);
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getRequestPrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getRequestPrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return NumCountProtos.NumCountRequest.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getResponsePrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getResponsePrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return NumCountProtos.NumCountResponse.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

      };
    }

    /**
     * <code>rpc getNumCount(.NumCountRequest) returns (.NumCountResponse);</code>
     */
    public abstract void getNumCount(
        com.google.protobuf.RpcController controller,
        NumCountProtos.NumCountRequest request,
        com.google.protobuf.RpcCallback<NumCountProtos.NumCountResponse> done);

    public static final
        com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptor() {
      return NumCountProtos.getDescriptor().getServices().get(0);
    }
    public final com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }

    public final void callMethod(
        com.google.protobuf.Descriptors.MethodDescriptor method,
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Message request,
        com.google.protobuf.RpcCallback<
          com.google.protobuf.Message> done) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.callMethod() given method descriptor for wrong " +
          "service type.");
      }
      switch(method.getIndex()) {
        case 0:
          this.getNumCount(controller, (NumCountProtos.NumCountRequest)request,
            com.google.protobuf.RpcUtil.<NumCountProtos.NumCountResponse>specializeCallback(
              done));
          return;
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getRequestPrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return NumCountProtos.NumCountRequest.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getResponsePrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return NumCountProtos.NumCountResponse.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public static Stub newStub(
        com.google.protobuf.RpcChannel channel) {
      return new Stub(channel);
    }

    public static final class Stub extends NumCountProtos.NumCountService implements Interface {
      private Stub(com.google.protobuf.RpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.RpcChannel channel;

      public com.google.protobuf.RpcChannel getChannel() {
        return channel;
      }

      public  void getNumCount(
          com.google.protobuf.RpcController controller,
          NumCountProtos.NumCountRequest request,
          com.google.protobuf.RpcCallback<NumCountProtos.NumCountResponse> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          NumCountProtos.NumCountResponse.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            NumCountProtos.NumCountResponse.class,
            NumCountProtos.NumCountResponse.getDefaultInstance()));
      }
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
      return new BlockingStub(channel);
    }

    public interface BlockingInterface {
      public NumCountProtos.NumCountResponse getNumCount(
          com.google.protobuf.RpcController controller,
          NumCountProtos.NumCountRequest request)
          throws com.google.protobuf.ServiceException;
    }

    private static final class BlockingStub implements BlockingInterface {
      private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.BlockingRpcChannel channel;

      public NumCountProtos.NumCountResponse getNumCount(
          com.google.protobuf.RpcController controller,
          NumCountProtos.NumCountRequest request)
          throws com.google.protobuf.ServiceException {
        return (NumCountProtos.NumCountResponse) channel.callBlockingMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          NumCountProtos.NumCountResponse.getDefaultInstance());
      }

    }

    // @@protoc_insertion_point(class_scope:NumCountService)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_NumCountRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_NumCountRequest_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_NumCountResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_NumCountResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016NumCount.proto\"\036\n\017NumCountRequest\022\013\n\003s" +
      "ex\030\001 \002(\005\"!\n\020NumCountResponse\022\r\n\005count\030\001 " +
      "\002(\0032E\n\017NumCountService\0222\n\013getNumCount\022\020." +
      "NumCountRequest\032\021.NumCountResponseB\023B\016Nu" +
      "mCountProtos\210\001\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_NumCountRequest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_NumCountRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_NumCountRequest_descriptor,
              new java.lang.String[] { "Sex", });
          internal_static_NumCountResponse_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_NumCountResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_NumCountResponse_descriptor,
              new java.lang.String[] { "Count", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
