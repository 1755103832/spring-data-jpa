/*!
 * selectInput v1.0
 * author JerryZst
 * qq 1309579432
 * Date: 2020/8/12 0007
 */
layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    // var form = layui.form;
    var _this = this;
    var _MOD = 'selectInput';
    var selectedCss = 'layui-form-selected';
    var upCss = 'layui-form-selectup';
    var selectInputClass = 'selectInput';
    var x, y;
    if ($('#ew-css-selectInput').length <= 0) {
        layui.link(layui.cache.base + 'selectInput/selectInput.css');
    }
    // 加载全局鼠标位置
    $(document).mousemove(function (e) {
        x = e.pageX;
        y = e.pageY;
    });
    var selectInput = function (opt) {
        this.version = 'selectInput-1.0';
        this.tmpId = new Date().getTime();
        this._input = 'input-' + this.tmpId;
        this._select = 'select-' + this.tmpId;
        this._class = 'dd' + this.tmpId;
        // 配置项
        this.options = $.extend(true, {
            method: 'GET',
            error: opt.error || null,
            data: opt.data || [],
            on: opt.on || null,
            remoteMethod: opt.remoteMethod || null
        }, opt);
        this.init();  // 初始化
        this.bindEvents();  // 绑定事件
    };

    /**
     * 初始化数据层
     */
    selectInput.prototype.init = function () {
        var that = this;
        var options = this.options;
        //var components = this.getComponents();
        // 渲染数据
        // 直接赋值模式
        if (!options.remoteSearch) {
            if (options.data.length > 0) {
                that.renderBody(options.data);
            } else if (options.url) {
                if (!options.where) options.where = {};
                $.ajax({
                    url: options.url,
                    data: options.contentType && options.contentType.indexOf('application/json') === 0 ? JSON.stringify(options.where) : options.where,
                    headers: options.headers,
                    type: options.method,
                    dataType: 'json',
                    contentType: options.contentType,
                    success: function (res) {
                        var data = options.parseData ? options.parseData(res) : res;
                        that.renderBody(data);
                        options.done && options.done(res.data, 1);
                    },
                    error: function (xhr) {
                        return options.error ? options.error({
                            code: xhr.status,
                            msg: xhr.statusText,
                            xhr: xhr
                        }) : console.error(xhr.statusText);
                    }
                });
            }
        } else if (options.remoteSearch && options.remoteMethod) {
            that.renderBody([]);
        }
    };


    /** 获取各个组件 */
    selectInput.prototype.getComponents = function () {
        var that = this;
        var $elem = $(that.options.elem);
        var filter = $elem.attr('lay-filter');
        if (!filter) {
            filter = that.options.elem.substring(1);
            $elem.attr('lay-filter', filter);
        }
        return {
            $elem: $elem,  // 容器
            filter: filter, // 容器的lay-filter
            $inputElem: $('#' + this._input),
            $selectElem: $('#' + this._select),
            $ddElem: $('.' + this._class)
        };
    };
    /**
     * 加载input
     */
    selectInput.prototype.renderInput = function () {
        var options = this.options;
        var name = options.name ? options.name : this.version + this.tmpId;
        var placeholder = options.placeholder ? options.placeholder : '请输入内容';
        var initValue = options.initValue ? options.initValue : '';
        return '<input type="text" value="' + initValue + '"  name="' + name + '"  id="' + this._input + '" autocomplete="off" placeholder="' + placeholder + '"  class="layui-input">';
    };

    /**
     * 加载主体内容
     * @param data
     */
    selectInput.prototype.renderBody = function (data) {
        var _input = this.renderInput();
        var components = this.getComponents();
        var bodyHtml = '<div class="layui-form-selectInput" id="' + this._select + '">' + '<dl class="layui-anim layui-anim-upbit ' + selectInputClass + '" style="">';
        if (!data) data = [];
        if (data.length > 0) {
            var contentHtml = '';
            for (var i = 0; i < data.length; i++) {
                contentHtml += '<dd lay-value="' + data[i]['value'] + '" class="' + this._class + '">' + data[i]['name'] + '</dd>';
            }
            bodyHtml = _input + bodyHtml + contentHtml + '</dl></div>';
        } else {
            bodyHtml = _input + bodyHtml + '</dl></div>';
        }
        components.$elem.html(bodyHtml);
        return bodyHtml;
    };

    /**
     * 绑定事件
     */
    selectInput.prototype.bindEvents = function () {
        var that = this;
        var components = this.getComponents();
        /* 事件公共返回对象 */
        var commonMember = function (ext, isInput) {
            var $item = $(ext);
            var obj = {
                elem: $item,  //当前item的dom
                data: isInput ? $item.val() : $item.attr('lay-value'),
                id: $(this).id // 当前item索引
            };
            return $.extend(obj, ext);
        };

        // 绑定input输入事件
        components.$inputElem.off('input propertychange').on('input propertychange', function () {
            // 执行我们的正常的操作
            var value = $(this).val();
            // 执行重载dl数据
            var cb = function (data) {
                if (data && typeof (data) === 'string') {
                    data = JSON.parse(data)
                }
                if (!data) data = [];
                if (data.length > 0) {
                    data = that.options.parseData ? that.options.parseData(data) : data;
                    var contentHtml = '';
                    for (var i = 0; i < data.length; i++) {
                        contentHtml += '<dd lay-value="' + data[i]['value'] + '" class="' + that._class + '">' + data[i]['name'] + '</dd>';
                    }
                    components.$selectElem.find('dl').html(contentHtml);
                    components.$selectElem.addClass(selectedCss + ' ' + upCss);
                    components.$selectElem.find("dl").css({"display": "block"});
                    that.bindEvents();
                } else {
                    //components.$selectElem.removeClass(selectedCss + ' ' + upCss);
                    components.$selectElem.find("dl").css({"display": "none"});
                }
            };
            if (!that.options.remoteSearch) {
                if (value !== '' && value !== null && value !== undefined) {
                    $(this).next().addClass(selectedCss + ' ' + upCss);
                    $(this).next().find("dl").css({"display": "block"});
                    var dl = $(this).next().find("dl").children();
                    var j = -1;
                    for (var i = 0; i < dl.length; i++) {
                        if (dl[i].innerHTML.indexOf(value) <= -1) {
                            dl[i].style.display = "none";
                            j++;
                        } else {
                            dl[i].style.display = "block";
                        }
                        if (j === (dl.length - 1)) {
                            $(this).next().find("dl").css({"display": "none"});
                        }
                    }
                } else {
                    //$(this).next().removeClass(selectedCss + ' ' + upCss);
                    $(this).next().find("dl").css({"display": "none"});
                }
            } else if (that.options.remoteSearch && that.options.remoteMethod) {
                // 远程执行搜索
                that.options.remoteMethod(value, cb);
            }
            layui.event.call(this, _MOD, 'itemInput(' + components.filter + ')', commonMember(this, true));
        });

        // 绑定input光标消失事件
        components.$inputElem.off('blur').on('blur', function () {
            var elem = $(this).next().find('dl');
            var y1 = elem.offset().top;  //div上面两个的点的y值
            var y2 = y1 + elem.height();//div下面两个点的y值
            var x1 = elem.offset().left;  //div左边两个的点的x值
            var x2 = x1 + elem.width();  //div右边两个点的x的值
            if (x < x1 || x > x2 || y < y1 || y > y2) {
                //$(this).next().removeClass(selectedCss + ' ' + upCss);
                elem.hide()
            }
        });

        // select 选择事件
        components.$ddElem.off('click').on('click', function () {
            // 执行我们的正常的操作
            $(this).parent().parent().prev().val($(this).text());
            //$(this).parent().parent().removeClass(selectedCss + ' ' + upCss);
            $(this).parent().css({"display": "none"});
            layui.event.call(this, _MOD, 'itemSelect(' + components.filter + ')', commonMember(this));
        });
    };

    /**
     * 监听事件
     * @param events
     * @param callback
     * @returns {*}
     */
    selectInput.prototype.on = function (events, callback) {
        return layui.onevent.call(this, _MOD, events, callback);
    };

    /**
     * 获取选中的value值
     * @param data
     * @returns {*}
     */
    selectInput.prototype.getValue = function (data) {
        var components = this.getComponents();
        return components.$inputElem.val();
    };

    /** 外部方法 */
    var iS = {
        /* 渲染 */
        render: function (options) {
            return new selectInput(options);
        },
        /* 事件监听 */
        on: function (events, callback) {
            return layui.onevent.call(this, _MOD, events, callback);
        }
    };
    exports(_MOD, iS);
});